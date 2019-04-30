package com.github.douglasmiguel7.queue.api;

import com.github.douglasmiguel7.queue.domain.AppUser;
import com.github.douglasmiguel7.queue.domain.Service;
import com.github.douglasmiguel7.queue.factory.ErrorFactory;
import com.github.douglasmiguel7.queue.factory.ServiceFactory;
import com.github.douglasmiguel7.queue.input.ServiceInput;
import com.github.douglasmiguel7.queue.mapper.ServiceMapper;
import com.github.douglasmiguel7.queue.output.ErrorOutput;
import com.github.douglasmiguel7.queue.output.ServiceOutput;
import com.github.douglasmiguel7.queue.search.AppUserSearch;
import com.github.douglasmiguel7.queue.search.ServiceSearch;
import com.github.douglasmiguel7.queue.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Date;
import java.util.List;

@RestController
public class ServiceAPI extends AbstractBaseV1API {

    private final ServiceSearch serviceSearch;

    private final ServiceMapper serviceMapper;

    private final AppUserSearch appUserSearch;

    private final ServiceFactory serviceFactory;

    private final ServiceService serviceService;

    @Autowired
    public ServiceAPI(ServiceSearch serviceSearch, ServiceMapper serviceMapper, AppUserSearch appUserSearch, ServiceFactory serviceFactory, ServiceService serviceService) {
        this.serviceSearch = serviceSearch;
        this.serviceMapper = serviceMapper;
        this.appUserSearch = appUserSearch;
        this.serviceFactory = serviceFactory;
        this.serviceService = serviceService;
    }

    @PostMapping("/services")
    @PreAuthorize("hasRole('ROLE_EMPLOYEE')")
    public ResponseEntity createService(@AuthenticationPrincipal Principal principal, @RequestBody @Valid ServiceInput serviceInput) {
        AppUser appUser = appUserSearch.searchByPrincipal(principal);

        Service service = serviceFactory.fabricate(appUser, serviceInput);

        ServiceOutput serviceOutput = serviceMapper.toOutput(service);

        return ResponseEntity.status(HttpStatus.CREATED).body(serviceOutput);
    }

    @GetMapping("/services")
    public ResponseEntity getServicesAvailable(@AuthenticationPrincipal Principal principal, @RequestParam(required = false) @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm") Date bookingDate, @RequestParam(required = false) Long companyId) {
        AppUser appUser = appUserSearch.searchByPrincipal(principal);

        List<Service> services = serviceSearch.searchAvailables(appUser, bookingDate, companyId);

        List<ServiceOutput> serviceOutputs = serviceMapper.toOutputs(services);

        return ResponseEntity.ok(serviceOutputs);
    }

    @DeleteMapping(value = "/services/{id}")
    @PreAuthorize("hasRole('ROLE_EMPLOYEE')")
    public ResponseEntity disableService(@AuthenticationPrincipal Principal principal, @PathVariable Long id) {
        AppUser appUser = appUserSearch.searchByPrincipal(principal);

        Service service = serviceSearch.searchByIdAndAppUser(id, appUser);

        if (service == null) {
            ErrorOutput errorOutput = ErrorFactory.fabricate("invalid id");

            return ResponseEntity.badRequest().body(errorOutput);
        }

        serviceService.disable(service);

        return ResponseEntity.ok().build();
    }

}
