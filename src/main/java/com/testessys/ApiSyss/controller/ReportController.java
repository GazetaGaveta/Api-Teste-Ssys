package com.testessys.ApiSyss.controller;

import com.testessys.ApiSyss.dto.request.EmployeeDTO;
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

    @GetMapping
    public List<EmployeeDTO> ageRange(){
        return reportService.ageRange();
    }
}
