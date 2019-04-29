package com.github.douglasmiguel7.queue.api;

import com.github.douglasmiguel7.queue.domain.Service;
import com.github.douglasmiguel7.queue.mapper.ServiceMapper;
import com.github.douglasmiguel7.queue.output.ServiceOutput;
import com.github.douglasmiguel7.queue.search.ServiceSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class ServiceAPI extends AbstractBaseV1API {

    private final ServiceSearch serviceSearch;

    private final ServiceMapper serviceMapper;

    @Autowired
    public ServiceAPI(ServiceSearch serviceSearch, ServiceMapper serviceMapper) {
        this.serviceSearch = serviceSearch;
        this.serviceMapper = serviceMapper;
    }

    @GetMapping("/services")
    public ResponseEntity getServicesAvailable(@RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm") Date bookingDate, @RequestParam(required = false) Long companyId) {
        List<Service> services = serviceSearch.searchAvailables(bookingDate, companyId);

        List<ServiceOutput> serviceOutputs = serviceMapper.toOutputs(services);

        return ResponseEntity.ok(serviceOutputs);
    }

}
