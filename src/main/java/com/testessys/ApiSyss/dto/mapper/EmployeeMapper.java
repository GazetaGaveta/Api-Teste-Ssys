package com.testessys.ApiSyss.dto.mapper;

import com.testessys.ApiSyss.dto.request.EmployeeDTO;
import com.testessys.ApiSyss.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Employee toModel(EmployeeDTO employeeDTO);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    EmployeeDTO toDTO(Employee employee);
}
