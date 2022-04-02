package com.testessys.ApiSyss.dto.mapper;

import com.testessys.ApiSyss.dto.request.ApiUserDTO;
import com.testessys.ApiSyss.entity.ApiUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ApiUserMapper {
    ApiUserMapper INSTANCE = Mappers.getMapper(ApiUserMapper.class);

    @Mapping(target = "password", source = "encodedPassword")
    ApiUser toModel(ApiUserDTO apiUserDTO, String encodedPassword);

    ApiUserDTO toDTO(ApiUser apiUser);
}
