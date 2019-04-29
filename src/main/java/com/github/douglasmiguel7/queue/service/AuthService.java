package com.github.douglasmiguel7.queue.service;

import com.github.douglasmiguel7.queue.domain.AppUser;
import com.github.douglasmiguel7.queue.repository.AppUserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthService implements UserDetailsService {

    private final AppUserRepository appUserRepository;

    @Autowired
    public AuthService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findOneByName(name).orElseThrow(() -> new UsernameNotFoundException(name));

        List<GrantedAuthority> authorities = new ArrayList<>();

        if (appUser.getCompany() != null) {
            authorities.add(new SimpleGrantedAuthority("ROLE_EMPLOYEE"));
        } else if (StringUtils.equalsIgnoreCase(appUser.getName(), "admin")) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else {
            authorities.add(new SimpleGrantedAuthority("ROLE_CUSTOMER"));
        }

        User user = new User(appUser.getName(), appUser.getPassword(), authorities);

        return user;
    }
}
