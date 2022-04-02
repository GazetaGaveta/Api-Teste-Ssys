package com.testessys.ApiSyss.repository;

import com.testessys.ApiSyss.entity.ApiUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApiUserRepository extends JpaRepository<ApiUser, Long> {

    public Optional<ApiUser> findByUsername(String username);
}
