package com.github.douglasmiguel7.queue.search;

import com.github.douglasmiguel7.queue.domain.AppUser;
import com.github.douglasmiguel7.queue.domain.Service;
import com.github.douglasmiguel7.queue.hardcode.AppUserRole;
import com.github.douglasmiguel7.queue.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Component
public class ServiceSearch {

    private final ServiceRepository serviceRepository;

    @Autowired
    public ServiceSearch(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public List<Service> searchAvailables(AppUser appUser, Date bookingDate, Long companyId) {
        if (AppUserRole.EMPLOYEE.equals(appUser.getRole())) {
            if (bookingDate != null) {
                return serviceRepository.findAllAvailableOrNot(bookingDate, appUser.getCompany().getId());
            } else {
                return serviceRepository.findAllByCompany(appUser.getCompany());
            }
        } else if (AppUserRole.CUSTOMER.equals(appUser.getRole())) {
            if (bookingDate != null && companyId == null) {
                return serviceRepository.findAllAvailable(bookingDate);
            } else if (bookingDate != null && companyId != null) {
                return serviceRepository.findAllAvailable(bookingDate, companyId);
            } else {
                return Collections.emptyList();
            }
        } else if (AppUserRole.ADMIN.equals(appUser.getRole())) {
            if (bookingDate != null && companyId == null) {
                return serviceRepository.findAllAvailableOrNot(bookingDate);
            } else if (bookingDate != null && companyId != null) {
                return serviceRepository.findAllAvailableOrNot(bookingDate, companyId);
            } else {
                return serviceRepository.findAll();
            }
        } else {
            return Collections.emptyList();
        }
    }

}
