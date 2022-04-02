package com.testessys.ApiSyss.data;

import com.testessys.ApiSyss.entity.ApiUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Data
@AllArgsConstructor
public class UserDetailData implements UserDetails {

    private final Optional<ApiUser> apiUser;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return apiUser.orElse(new ApiUser()).getPassword();
    }

    @Override
    public String getUsername() {
        return apiUser.orElse(new ApiUser()).getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
