package com.github.douglasmiguel7.queue.api;

import com.github.douglasmiguel7.queue.domain.AppUser;
import com.github.douglasmiguel7.queue.mapper.AppUserMapper;
import com.github.douglasmiguel7.queue.output.AppUserOutput;
import com.github.douglasmiguel7.queue.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AppUserAPI extends AbstractBaseV1API {

    private final AppUserRepository appUserRepository;

    private final AppUserMapper appUserMapper;

    @Autowired
    public AppUserAPI(AppUserRepository appUserRepository, AppUserMapper appUserMapper) {
        this.appUserRepository = appUserRepository;
        this.appUserMapper = appUserMapper;
    }

    @GetMapping("/app-users")
    public ResponseEntity getAppUsers() {
        List<AppUser> appUsers = appUserRepository.findAll();

        List<AppUserOutput> appUserOutputs = appUserMapper.toOutputs(appUsers);

        return ResponseEntity.ok(appUserOutputs);
    }

}
