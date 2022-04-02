package com.testessys.ApiSyss.dto.controller;

import com.testessys.ApiSyss.dto.request.ApiUserDTO;
import com.testessys.ApiSyss.dto.response.MessageResponseDTO;
import com.testessys.ApiSyss.services.ApiUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ApiUserController {

    private ApiUserService apiUserService;

    @GetMapping
    public List<ApiUserDTO> listAll(){
        return apiUserService.listAll();
    }

    @PostMapping
    public MessageResponseDTO createApiUser(@RequestBody @Valid ApiUserDTO employeeDTO){
        return apiUserService.createApiUser(employeeDTO);
    }
}
