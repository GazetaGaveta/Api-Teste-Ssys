package com.testessys.ApiSyss.services;

import com.testessys.ApiSyss.data.UserDetailData;
import com.testessys.ApiSyss.entity.ApiUser;
import com.testessys.ApiSyss.repository.ApiUserRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final ApiUserRepository apiUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<ApiUser> user = apiUserRepository.findByUsername(username);

        if(user.isEmpty()){
            throw new UsernameNotFoundException("Username, [" + username + "] not found!");
        }

        return new UserDetailData(user);
    }
}
