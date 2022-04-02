package com.testessys.ApiSyss.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiUserDTO {

    private Long id;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;
}
