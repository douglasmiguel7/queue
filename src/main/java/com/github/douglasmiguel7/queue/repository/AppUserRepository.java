package com.github.douglasmiguel7.queue.repository;

import com.github.douglasmiguel7.queue.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findOneByName(String name);

}
