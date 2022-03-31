package com.testessys.ApiSyss.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReportSalary {
    Employee lowest;
    Employee highest;
    double average;
}
