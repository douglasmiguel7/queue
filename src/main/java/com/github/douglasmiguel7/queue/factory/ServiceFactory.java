package com.github.douglasmiguel7.queue.factory;

import com.github.douglasmiguel7.queue.domain.AppUser;
import com.github.douglasmiguel7.queue.domain.Service;
import com.github.douglasmiguel7.queue.input.ServiceInput;
import com.github.douglasmiguel7.queue.mapper.ServiceMapper;
import com.github.douglasmiguel7.queue.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceFactory {

    private final ServiceMapper serviceMapper;

    private final ServiceRepository serviceRepository;

    @Autowired
    public ServiceFactory(ServiceMapper serviceMapper, ServiceRepository serviceRepository) {
        this.serviceMapper = serviceMapper;
        this.serviceRepository = serviceRepository;
    }

    public Service fabricate(AppUser appUser, ServiceInput serviceInput) {
        Service service = serviceMapper.toService(serviceInput);
        service.setCompany(appUser.getCompany());

        serviceRepository.save(service);

        return service;
    }

}
