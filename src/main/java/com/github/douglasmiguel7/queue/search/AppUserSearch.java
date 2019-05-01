package com.github.douglasmiguel7.queue.search;

import com.github.douglasmiguel7.queue.domain.AppUser;
import com.github.douglasmiguel7.queue.repository.AppUserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.Optional;

@Component
public class AppUserSearch {

    private final AppUserRepository appUserRepository;

    @Autowired
    public AppUserSearch(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public AppUser searchByPrincipal(Principal principal) {
        if (principal == null) {
            return null;
        }

        Optional<AppUser> optionalAppUser = searchByName(principal.getName());

        if (optionalAppUser.isPresent()) {
            return optionalAppUser.get();
        }

        return null;
    }

    public Optional<AppUser> searchByName(String name) {
        if (StringUtils.isBlank(name)) {
            return Optional.empty();
        }

        return appUserRepository.findOneByName(name);
    }
}
