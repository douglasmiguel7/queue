package com.github.douglasmiguel7.queue.service;

import com.github.douglasmiguel7.queue.domain.AppUser;
import com.github.douglasmiguel7.queue.repository.AppUserRepository;
import com.github.douglasmiguel7.queue.search.AppUserSearch;
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

    private final AppUserSearch appUserSearch;

    @Autowired
    public AuthService(AppUserRepository appUserRepository, AppUserSearch appUserSearch) {
        this.appUserSearch = appUserSearch;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        AppUser appUser = appUserSearch.searchByName(name).orElseThrow(() -> new UsernameNotFoundException(name));

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(appUser.getRole().getName()));

        User user = new User(appUser.getName(), appUser.getPassword(), authorities);

        return user;
    }
}
