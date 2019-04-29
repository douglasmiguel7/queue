package com.github.douglasmiguel7.queue.search;

import com.github.douglasmiguel7.queue.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ServiceSearch {

    private final ServiceRepository serviceRepository;

    @Autowired
    public ServiceSearch(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public List<com.github.douglasmiguel7.queue.domain.Service> searchAvailables(Date bookingDate, Long companyId) {
        if (companyId == null) {
            return serviceRepository.findAvailables(bookingDate);
        } else {
//            serviceRepository.findAvailables(bookingDate, companyId);
            return null;
        }
    }

}
