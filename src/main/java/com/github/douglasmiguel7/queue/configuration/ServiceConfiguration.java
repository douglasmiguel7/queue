package com.github.douglasmiguel7.queue.configuration;

import com.github.douglasmiguel7.queue.domain.Company;
import com.github.douglasmiguel7.queue.domain.Service;
import com.github.douglasmiguel7.queue.repository.CompanyRepository;
import com.github.douglasmiguel7.queue.repository.ServiceRepository;
import com.github.douglasmiguel7.queue.utils.Times;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.domain.Example;

import java.math.BigDecimal;

@Configuration
@DependsOn("setupComapnies")
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
        createServicesApplebees();
        createServicesOutback();

        return true;
    }

    private void createServicesOutback() {
        Company outback = getCompanyByName("Outback");

        Service caster = new Service();
        caster.setCompany(outback);
        caster.setName("Outback Caster");
        caster.setDescription("Pizza caster <3");
        caster.setPrice(new BigDecimal("45"));
        caster.setEndAt(Times.of(19));

        serviceRepository.save(caster);
    }

    private void createServicesApplebees() {
        Company applebees = getCompanyByName("Applebees");

        Service lunch = new Service();
        lunch.setCompany(applebees);
        lunch.setName("Applebees Lunch");
        lunch.setDescription("Your lunch is cheaper here =)");
        lunch.setPrice(BigDecimal.TEN);
        lunch.setEndAt(Times.of(14));

        Service executiveLunch = new Service();
        executiveLunch.setCompany(applebees);
        executiveLunch.setName("Applebees Executive");
        executiveLunch.setPrice(new BigDecimal("55"));
        executiveLunch.setEndless(true);

        serviceRepository.save(lunch);
        serviceRepository.save(executiveLunch);
    }

    private Company getCompanyByName(String name) {
        return companyRepository.findOne(Example.of(new Company(name))).get();
    }

}
