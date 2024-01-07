package org.person.service;

import org.person.entity.Admin;

import reactor.core.publisher.Mono;

public interface AdminService {
  Mono<Admin> save(Admin admin);
}
