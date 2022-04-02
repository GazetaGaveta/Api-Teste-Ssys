package com.testessys.ApiSyss.dto.controller;

import com.testessys.ApiSyss.dto.request.EmployeeDTO;
import com.testessys.ApiSyss.dto.response.MessageResponseDTO;
import com.testessys.ApiSyss.exception.EmployeeNotFoundException;
import com.testessys.ApiSyss.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/employees")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeeController {

    private EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDTO> listAll(){
        return employeeService.listAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createEmployee(@RequestBody @Valid EmployeeDTO employeeDTO){
        return employeeService.createEmployee(employeeDTO);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById (@PathVariable Long id, @RequestBody @Valid EmployeeDTO employeeDTO) throws EmployeeNotFoundException {
        return employeeService.updateById(id, employeeDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws EmployeeNotFoundException {
        employeeService.deleteById(id);
    }

    @GetMapping("/{id}")
    public EmployeeDTO findById(@PathVariable Long id) throws EmployeeNotFoundException {
        return employeeService.findById(id);
    }

}
