package com.github.douglasmiguel7.queue.service;

import com.github.douglasmiguel7.queue.domain.Service;
import com.github.douglasmiguel7.queue.repository.ServiceRepository;
import org.springframework.stereotype.Component;

@Component
public class ServiceService {

    private final ServiceRepository serviceRepository;

    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public void disable(Service service) {
        service.setActive(false);

        serviceRepository.save(service);
    }
    
}
