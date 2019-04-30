package com.github.douglasmiguel7.queue.configuration;

import com.github.douglasmiguel7.queue.domain.AppUser;
import com.github.douglasmiguel7.queue.domain.Company;
import com.github.douglasmiguel7.queue.hardcode.AppUserRole;
import com.github.douglasmiguel7.queue.repository.AppUserRepository;
import com.github.douglasmiguel7.queue.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.domain.Example;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@DependsOn("setupComapnies")
public class AppUserConfiguration {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final AppUserRepository appUserRepository;

    private final CompanyRepository companyRepository;

    @Autowired
    public AppUserConfiguration(BCryptPasswordEncoder bCryptPasswordEncoder, AppUserRepository appUserRepository, CompanyRepository companyRepository) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.appUserRepository = appUserRepository;
        this.companyRepository = companyRepository;
    }

    @Bean
    public boolean setupAppUsers() {
        createAdmin();
        createCustomer();
        createEmployeeOutback();
        createEmployeeApplebees();

        return true;
    }

    private void createAdmin() {
        AppUser appUser = new AppUser();
        appUser.setNickname("Administrator");
        appUser.setName("admin");
        appUser.setPassword(bCryptPasswordEncoder.encode("admin"));
        appUser.setRole(AppUserRole.ADMIN);

        appUserRepository.save(appUser);
    }

    private void createCustomer() {
        AppUser appUser = new AppUser();
        appUser.setNickname("Custumer");
        appUser.setName("customer");
        appUser.setPassword(bCryptPasswordEncoder.encode("customer"));
        appUser.setRole(AppUserRole.CUSTOMER);

        appUserRepository.save(appUser);
    }

    private void createEmployeeOutback() {
        Company company = new Company();
        company.setName("Outback");

        company = companyRepository.findOne(Example.of(company)).get();

        AppUser appUser = new AppUser();
        appUser.setNickname("Employee Applebees");
        appUser.setName("emp1");
        appUser.setPassword(bCryptPasswordEncoder.encode("emp1"));
        appUser.setCompany(company);
        appUser.setRole(AppUserRole.EMPLOYEE);

        appUserRepository.save(appUser);
    }

    private void createEmployeeApplebees() {
        Company company = new Company();
        company.setName("Applebees");

        company = companyRepository.findOne(Example.of(company)).get();

        AppUser appUser = new AppUser();
        appUser.setNickname("Employee Applebees");
        appUser.setName("emp2");
        appUser.setPassword(bCryptPasswordEncoder.encode("emp2"));
        appUser.setCompany(company);
        appUser.setRole(AppUserRole.EMPLOYEE);

        appUserRepository.save(appUser);
    }

    private Company getCompanyByName(String name) {
        return companyRepository.findOne(Example.of(new Company(name))).get();
    }

}
