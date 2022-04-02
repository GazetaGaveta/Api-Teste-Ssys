package com.testessys.ApiSyss.services;

import com.testessys.ApiSyss.dto.mapper.ApiUserMapper;
import com.testessys.ApiSyss.dto.request.ApiUserDTO;
import com.testessys.ApiSyss.dto.response.MessageResponseDTO;
import com.testessys.ApiSyss.entity.ApiUser;
import com.testessys.ApiSyss.repository.ApiUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ApiUserService {

    private ApiUserRepository apiUserRepository;

    private final ApiUserMapper apiUserMapper = ApiUserMapper.INSTANCE;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public MessageResponseDTO createApiUser(ApiUserDTO apiUserDTO){
        ApiUser apiUserToSave = apiUserMapper.toModel(apiUserDTO, encodePassword(apiUserDTO.getPassword()));

        ApiUser savedApiUser = apiUserRepository.save(apiUserToSave);

        return createMessageResponse("Created API User. ID: " + savedApiUser.getId());
    }

    public String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }

    private MessageResponseDTO createMessageResponse(String message){
        return MessageResponseDTO
                .builder()
                .message(message)
                .build();
    }
}
