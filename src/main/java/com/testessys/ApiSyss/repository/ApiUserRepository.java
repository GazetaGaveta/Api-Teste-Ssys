package com.testessys.ApiSyss.repository;

import com.testessys.ApiSyss.entity.ApiUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiUserRepository extends JpaRepository<ApiUser, Long> {
}
