CREATE EXTENSION IF NOT EXISTS "uuid-ossp";


create table users
(
    uid               uuid       default uuid_generate_v4()      not null
        primary key,
    created_at        timestamp  default now()                   not null,
    modified_at       timestamp  default now(),
    username          varchar(128)                               not null,
    email             varchar(128),
    password          text,
    phone_number      varchar(32),
    enabled           boolean    default true,
    is_admin          boolean    default false,
    last_profile_uid  uuid,
    language          varchar(2) default 'EN'::character varying not null,
    email_verified    boolean    default false,
    prefer_mobile_2fa varchar(20),
    profile_type      varchar(24)                                not null,
    is_password_set   boolean    default false,
    is_social         boolean    default false                   not null,
    is_2fa_enabled    boolean    default false                   not null,
    secret_key        varchar(64)
);

create table profiles
(
    uid         uuid      default uuid_generate_v4() not null
        primary key,
    created_at  timestamp default now()              not null,
    modified_at timestamp default now(),
    user_uid    uuid unique                                 not null
        references users
        on delete cascade,
    type        varchar(24)                          not null,
    verified    boolean   default false
);

create index fki_profiles_user_uid_fkey
    on profiles (user_uid);

create table countries
(
    id          serial
        primary key,
    created_at  timestamp default now() not null,
    modified_at timestamp,
    name        varchar(64)             not null
        unique,
    alpha3      varchar(3)              not null
        unique,
    is_active   boolean   default true,
    alpha2      varchar(2)
        unique,
    unique (name, alpha3)
);

create table users_profile_filters
(
    id           bigserial
        primary key,
    created_at   timestamp default now() not null,
    modified_at  timestamp,
    profile_uid  uuid                    not null
        references profiles
        on delete cascade,
    user_uid     uuid                    not null
        references users
        on delete cascade,
    profile_type varchar(24),
    verified     boolean
);

create table users_countries
(
    user_uid   uuid    not null
        references users
        on delete cascade,
    country_id integer not null
        references countries
            on delete cascade
);

create table addresses
(
    id          bigserial
        primary key,
    created_at  timestamp default now() not null,
    modified_at timestamp default now(),
    country_id  integer                 not null
        references countries
            on delete cascade,
    address     varchar(255),
    zip_code    varchar(32),
    archived_at timestamp,
    city        varchar(255),
    state       varchar(255)
);

create table admins
(
    id          serial
        primary key,
    created_at  timestamp default now() not null,
    modified_at timestamp,
    profile_uid uuid                    not null
        references profiles
        on delete cascade,
    name        varchar(32),
    surname     varchar(32),
    status      varchar(10),
    archived_at timestamp
);

create table authorities
(
    id           serial
        primary key,
    created_at   timestamp default now() not null,
    modified_at  timestamp,
    profile_type varchar(24)             not null,
    authority    varchar(128)            not null,
    constraint authority_profile_type_idx
        unique (authority, profile_type)
);

create table individuals
(
    id                       bigserial
        primary key,
    created_at               timestamp default now() not null,
    modified_at              timestamp default now(),
    first_name               varchar(32),
    last_name                varchar(32),
    date_of_birth            timestamp,
    passport_number          varchar(32),
    personal_identity_number varchar(64),
    gender                   varchar(10),
    status                   varchar(25)             not null,
    verified_at              timestamp,
    archived_at              timestamp,
    email                    varchar(50),
    phone                    varchar(20)
        constraint individuals_phone_idx
        unique,
    filled                   boolean   default false,
    profile_uid              uuid                    not null
        references profiles
        on delete cascade,
    applicant_id             varchar(255)
        unique,
    address_id               bigint                  not null
        references addresses
);

create table merchants
(
    id                  bigserial
        primary key,
    created_at          timestamp default now() not null,
    modified_at         timestamp default now(),
    company_name        varchar(50)             not null,
    email               varchar(50),
    phone_number        varchar(20),
    registration_number varchar(64)
        unique,
    verified_at         timestamp,
    archived_at         timestamp,
    status              varchar(25),
    profile_uid         uuid                    not null
        references profiles
        on delete cascade,
    filled              boolean   default false,
    applicant_id        varchar(255)
        unique,
    address_id          bigint                  not null
        references addresses,
    merchant_api_key    varchar(255)
        unique,
    merchant_logo_url   varchar(2048),
    unique (company_name)
);

create table profile_wallet_types
(
    id             bigserial
        primary key,
    user_uid       uuid    not null
        references users
        on delete cascade,
    profile_uid    uuid    not null
        references profiles
        on delete cascade,
    wallet_type_id integer not null,
    constraint user_uid_wallet_type_id_idx
        unique (profile_uid, wallet_type_id)
);

create table verification_statuses
(
    id                  serial
        primary key,
    created_at          timestamp default now(),
    profile_type        varchar(12)                                                          not null,
    target_profile_uid  uuid                                                                 not null
        constraint verification_statuses_target_profile_uid_fkey
        references profiles,
    applicant_id        varchar(255)
        constraint statuses_applicant_id_key
        unique,
    details             text,
    verification_status varchar(25),
    modified_at         timestamp default now()
);

create table profile_history
(
    id                      serial
        primary key,
    created_at              timestamp default now(),
    modified_at             timestamp default now(),
    profile_type            varchar(12) not null,
    target_profile_uid      uuid        not null
        references profiles,
    changed_by_profile_type varchar(12),
    reason                  varchar,
    comment                 varchar(512),
    changed_by_user_uid     uuid
        references users,
    changed_values          jsonb
);

create table profile_required_fields
(
    uid                 uuid        default uuid_generate_v4() not null
        primary key,
    created_at          timestamp   default now()              not null,
    modified_at         timestamp,
    country_alpha3_code char(3),
    validation_type     varchar(50),
    validation_rules    varchar(255),
    data_type           varchar(50)                            not null,
    key                 varchar(50)                            not null,
    language            char(2)                                not null,
    representation_name varchar(50)                            not null,
    description         varchar(50),
    default_value       varchar(50),
    profile_type        varchar(24) default 'INDIVIDUAL'::character varying,
    sorting_index       bigint      default 0                  not null,
    placeholder         varchar(255),
    constraint country_key_constraint
        unique (key, country_alpha3_code, language)
);

create table merchant_members
(
    id              bigserial
        primary key,
    created_at      timestamp   default now()                             not null,
    modified_at     timestamp   default now()                             not null,
    merchant_id     bigint                                                not null
        references merchants
            on delete cascade,
    first_name      varchar(255),
    last_name       varchar(255),
    email           varchar(255)                                          not null,
    phone_number    varchar(50),
    member_role     varchar(50),
    status          varchar(50) default 'VERIFICATION'::character varying not null,
    applicant_id    varchar(50),
    invitation_link varchar(255),
    verified        boolean     default false                             not null,
    filled          boolean,
    verified_at     timestamp,
    archived_at     timestamp,
    profile_uid     uuid                                                  not null
        references profiles
        on delete cascade
);

create table merchant_members_invitations
(
    uid         uuid      default uuid_generate_v4() not null
        primary key,
    created_at  timestamp default now()              not null,
    expires_in  timestamp                            not null,
    merchant_id bigint                               not null
        references merchants
            on delete cascade,
    first_name  varchar(255)                         not null,
    last_name   varchar(255)                         not null,
    email       varchar(255)                         not null,
    role        varchar(50)                          not null,
    status      varchar(55)
);

create table operations_members_invitations
(
    uid        uuid      default uuid_generate_v4() not null
        primary key,
    created_at timestamp default now()              not null,
    expires_in timestamp                            not null,
    first_name varchar(255)                         not null,
    last_name  varchar(255)                         not null,
    email      varchar(255)                         not null,
    status     varchar(55)                          not null,
    role       varchar(50)                          not null
);

create table operations_members
(
    id          bigserial
        primary key,
    created_at  timestamp default now() not null,
    modified_at timestamp default now() not null,
    first_name  varchar(255)            not null,
    last_name   varchar(255)            not null,
    email       varchar(255)            not null,
    profile_uid uuid                    not null
        references profiles
        on delete cascade,
    status      varchar(55)             not null,
    role        varchar(50)             not null,
    archived_at timestamp
);

create table operations_history
(
    id                     bigserial
        primary key,
    created_at             timestamp with time zone default now() not null,
    key                    varchar(56)                            not null,
    reason                 varchar(256),
    changed_by_profile_uid uuid                                   not null
        references profiles
        on delete cascade,
    target                 varchar(256),
    changed_values         jsonb
);

create table operations_history_keys
(
    id           serial
        primary key,
    profile_type varchar(24),
    screen       varchar(56)                                not null,
    key          varchar(56)                                not null,
    description  text       default ''::text                not null,
    language     varchar(2) default 'EN'::character varying not null
);