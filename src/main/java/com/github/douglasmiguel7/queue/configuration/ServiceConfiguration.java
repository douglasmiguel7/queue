package com.github.douglasmiguel7.queue.configuration;

import com.github.douglasmiguel7.queue.domain.Company;
import com.github.douglasmiguel7.queue.domain.Service;
import com.github.douglasmiguel7.queue.repository.CompanyRepository;
import com.github.douglasmiguel7.queue.repository.ServiceRepository;
import com.github.douglasmiguel7.queue.utils.Times;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Example;

import java.math.BigDecimal;

@Configuration
public class ServiceConfiguration {

    private final CompanyRepository companyRepository;

    private final ServiceRepository serviceRepository;

    @Autowired
    public ServiceConfiguration(CompanyRepository companyRepository, ServiceRepository serviceRepository) {
        this.companyRepository = companyRepository;
        this.serviceRepository = serviceRepository;
    }

    @Bean
    public boolean setupServices() {
        Company company = new Company();
        company.setName("Outback");

        company = companyRepository.findOne(Example.of(company)).get();

        createLunchTimeService(company);

        return true;
    }

    private void createLunchTimeService(Company company) {
        Service service = new Service();
        service.setCompany(company);
        service.setName("Lunch Time!");
        service.setDescription("Your lunch is cheaper here =)");
        service.setPrice(BigDecimal.TEN);
        service.setEndAt(Times.of(14));

        serviceRepository.save(service);
    }

}
