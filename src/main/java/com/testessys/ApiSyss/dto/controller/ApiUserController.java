package com.testessys.ApiSyss.dto.controller;

import com.testessys.ApiSyss.dto.request.ApiUserDTO;
import com.testessys.ApiSyss.dto.response.MessageResponseDTO;
import com.testessys.ApiSyss.services.ApiUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/user")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ApiUserController {

    private ApiUserService apiUserService;

    @PostMapping
    public MessageResponseDTO createApiUser(@RequestBody @Valid ApiUserDTO employeeDTO){
        return apiUserService.createApiUser(employeeDTO);
    }
}