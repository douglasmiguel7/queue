package com.github.douglasmiguel7.queue.configuration;

import com.github.douglasmiguel7.queue.domain.Company;
import com.github.douglasmiguel7.queue.repository.CompanyRepository;
import com.github.douglasmiguel7.queue.utils.Times;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CompanyConfiguration {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyConfiguration(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Bean
    public boolean setupComapnies() {
        createOutback();
        createApplebees();

        return true;
    }

    private void createApplebees() {
        Company company = new Company();
        company.setName("Applebees");
        company.setOpenAt(Times.of(11));
        company.setClosesAt(Times.of(18));

        companyRepository.save(company);
    }

    private void createOutback() {
        Company company = new Company();
        company.setName("Outback");
        company.setOpenAt(Times.of(14));
        company.setClosesAt(Times.of(21));

        companyRepository.save(company);
    }

}
