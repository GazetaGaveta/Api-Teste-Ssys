package com.testessys.ApiSyss.services;

import com.testessys.ApiSyss.dto.mapper.EmployeeMapper;
import com.testessys.ApiSyss.dto.request.EmployeeDTO;
import com.testessys.ApiSyss.entity.Employee;
import com.testessys.ApiSyss.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ReportService {
    private EmployeeRepository employeeRepository;

    private final EmployeeMapper employeeMapper = EmployeeMapper.INSTANCE;

    public List<EmployeeDTO> ageRange(){
        List<Employee> youngerEmployees, olderEmployees;
        List<LocalDate> agesEmployees;
        LocalDate youngerAge, olderAge;

        List<Employee> allEmployees = employeeRepository.findAll();
        List<Employee> ageRangeEmployees = new ArrayList<Employee>();

        agesEmployees = allEmployees.stream().map(employee -> employee.getBirthDate()).collect(Collectors.toList());

        youngerAge = allEmployees
                .stream()
                .map(employee -> employee.getBirthDate())
                .min(LocalDate::compareTo)
                .get();

        youngerEmployees = allEmployees
                .stream()
                .sorted((employee1, employee2) -> employee1.getBirthDate().compareTo(employee2.getBirthDate()))
                .filter(employee -> employee.getBirthDate() == youngerAge)
                .collect(Collectors.toList());

        olderAge = allEmployees
                .stream()
                .map(employee -> employee.getBirthDate())
                .max(LocalDate::compareTo)
                .get();

        olderEmployees = allEmployees
                .stream()
                .sorted((employee1, employee2) -> employee1.getBirthDate().compareTo(employee2.getBirthDate()))
                .filter(employee -> employee.getBirthDate() == olderAge)
                .collect(Collectors.toList());

        ageRangeEmployees.add(youngerEmployees.get(0));
        ageRangeEmployees.add(olderEmployees.get(0));

        return ageRangeEmployees
                .stream()
                .map(employeeMapper::toDTO)
                .collect(Collectors.toList());
    }
}
