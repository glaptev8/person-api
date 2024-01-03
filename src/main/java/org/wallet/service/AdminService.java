package org.wallet.service;

import org.wallet.entity.Admin;

import reactor.core.publisher.Mono;

public interface AdminService {
  Mono<Admin> save(Admin admin);
}
