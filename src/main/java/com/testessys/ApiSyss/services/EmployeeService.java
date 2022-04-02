package com.testessys.ApiSyss.services;

import com.testessys.ApiSyss.dto.mapper.EmployeeMapper;
import com.testessys.ApiSyss.dto.request.EmployeeDTO;
import com.testessys.ApiSyss.dto.response.MessageResponseDTO;
import com.testessys.ApiSyss.entity.Employee;
import com.testessys.ApiSyss.exception.EmployeeNotFoundException;
import com.testessys.ApiSyss.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    private final EmployeeMapper employeeMapper = EmployeeMapper.INSTANCE;

    public List<EmployeeDTO> listAll(){
        List<Employee> allEmployees = employeeRepository.findAll();

        return allEmployees
                .stream()
                .map(employeeMapper::toDTO)
                .collect(Collectors.toList());
    }

    public MessageResponseDTO createEmployee(EmployeeDTO employeeDTO){
        Employee employeeToSave = employeeMapper.toModel(employeeDTO);

        Employee savedEmployee = employeeRepository.save(employeeToSave);

        return createMessageResponse("Created Employee. ID: " + savedEmployee.getId());
    }

    public MessageResponseDTO updateById(Long id, EmployeeDTO employeeDTO) throws EmployeeNotFoundException {
        verifyIfExists(id);

        Employee employeeToUpdate = employeeMapper.toModel(employeeDTO);

        Employee updatedEmployee = employeeRepository.save(employeeToUpdate);

        return createMessageResponse("Updated Employee. ID: " + updatedEmployee.getId());
    }

    public EmployeeDTO findById(Long id) throws EmployeeNotFoundException{

        Employee foundEmployee = verifyIfExists(id);

        return employeeMapper.toDTO(foundEmployee);
    }

    public void deleteById(Long id) throws EmployeeNotFoundException {
        verifyIfExists(id);

        employeeRepository.deleteById(id);
    }

    private Employee verifyIfExists(Long id) throws EmployeeNotFoundException {
        return employeeRepository
                .findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found! ID: " + id));
    }

    private MessageResponseDTO createMessageResponse(String message){
        return MessageResponseDTO
                .builder()
                .message(message)
                .build();
    }
}
