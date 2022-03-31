package com.testessys.ApiSyss.controller;

import com.testessys.ApiSyss.dto.request.EmployeeDTO;
import com.testessys.ApiSyss.entity.ReportAge;
import com.testessys.ApiSyss.entity.ReportSalary;
import com.testessys.ApiSyss.exception.EmployeeNotFoundException;
import com.testessys.ApiSyss.services.EmployeeService;
import com.testessys.ApiSyss.services.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/reports/employees")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ReportController {
    private ReportService reportService;

    @GetMapping("/salary")
    public ReportSalary salaryRange() throws EmployeeNotFoundException {
        return reportService.salaryRange();
    }

    @GetMapping("/age")
    public ReportAge ageRange() throws EmployeeNotFoundException {
        return reportService.ageRange();
    }
}
