package com.testessys.ApiSyss.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private Long id;

    private String name;

    @Email
    private String email;

    private String department;

    @NotNull
    @PositiveOrZero
    private double salary;

    @NotEmpty
    @Past
    private String birthDate;
}
