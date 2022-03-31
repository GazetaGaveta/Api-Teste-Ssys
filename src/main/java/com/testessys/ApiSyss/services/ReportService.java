package com.testessys.ApiSyss.services;

import com.testessys.ApiSyss.dto.mapper.EmployeeMapper;
import com.testessys.ApiSyss.dto.request.EmployeeDTO;
import com.testessys.ApiSyss.entity.Employee;
import com.testessys.ApiSyss.entity.ReportAge;
import com.testessys.ApiSyss.entity.ReportSalary;
import com.testessys.ApiSyss.exception.EmployeeNotFoundException;
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

    public ReportAge ageRange() throws EmployeeNotFoundException {
        List<Employee> youngerEmployees, olderEmployees;
        List<LocalDate> agesEmployees;
        LocalDate youngerDate, olderDate;
        double youngerAge, olderAge, average;

        List<Employee> allEmployees = employeeRepository.findAll();

        if(allEmployees.isEmpty()) throw new EmployeeNotFoundException("Employee not found!");

        agesEmployees = allEmployees.stream().map(employee -> employee.getBirthDate()).collect(Collectors.toList());

        youngerDate = allEmployees
                .stream()
                .map(employee -> employee.getBirthDate())
                .min(LocalDate::compareTo)
                .get();

        youngerEmployees = allEmployees
                .stream()
                .sorted((employee1, employee2) -> employee1.getBirthDate().compareTo(employee2.getBirthDate()))
                .filter(employee -> employee.getBirthDate() == youngerDate)
                .collect(Collectors.toList());

        olderDate = allEmployees
                .stream()
                .map(employee -> employee.getBirthDate())
                .max(LocalDate::compareTo)
                .get();

        olderEmployees = allEmployees
                .stream()
                .sorted((employee1, employee2) -> employee1.getBirthDate().compareTo(employee2.getBirthDate()))
                .filter(employee -> employee.getBirthDate() == olderDate)
                .collect(Collectors.toList());

        youngerAge = youngerDate.until(LocalDate.now()).getYears();
        olderAge = olderDate.until(LocalDate.now()).getYears();

        average = (youngerAge + olderAge)/2;

        return new ReportAge(youngerEmployees.get(0), olderEmployees.get(0), average);
    }

    public ReportSalary salaryRange() throws EmployeeNotFoundException {
        List<Employee> lowestEmployees, highestEmployees;
        List<Double> salaryEmployees;
        double lowestSalary, highestSalary, average;

        List<Employee> allEmployees = employeeRepository.findAll();

        if(allEmployees.isEmpty()) throw new EmployeeNotFoundException("Employee not found!");

        lowestSalary = allEmployees
                .stream()
                .map(employee -> employee.getSalary())
                .min(Double::compareTo)
                .get();

        lowestEmployees = allEmployees
                .stream()
                .sorted((employee1, employee2) -> employee1.getSalary().compareTo(employee2.getSalary()))
                .filter(employee -> employee.getSalary() == lowestSalary)
                .collect(Collectors.toList());

        highestSalary = allEmployees
                .stream()
                .map(employee -> employee.getSalary())
                .max(Double::compareTo)
                .get();

        highestEmployees = allEmployees
                .stream()
                .sorted((employee1, employee2) -> employee1.getSalary().compareTo(employee2.getSalary()))
                .filter(employee -> employee.getSalary() == highestSalary)
                .collect(Collectors.toList());

        average = (lowestSalary + highestSalary)/2;

        return new ReportSalary(lowestEmployees.get(0), highestEmployees.get(0), average);
    }
}
