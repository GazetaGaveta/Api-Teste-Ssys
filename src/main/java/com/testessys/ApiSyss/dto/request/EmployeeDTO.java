package com.testessys.ApiSyss.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;

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

    @NotNull
    @Past
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthDate;
}
