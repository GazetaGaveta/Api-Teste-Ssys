package com.testessys.ApiSyss.repository;

import com.testessys.ApiSyss.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
