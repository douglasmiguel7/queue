package com.github.douglasmiguel7.queue.repository;

import com.github.douglasmiguel7.queue.domain.Company;
import com.github.douglasmiguel7.queue.domain.Service;
import com.github.douglasmiguel7.queue.hardcode.HibernateQueryLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ServiceRepository extends JpaRepository<Service, Long> {

    List<Service> findAllByCompany(Company company);

    @Query(HibernateQueryLanguage.SERVICES_AVAILABLE)
    List<Service> findAllAvailable(@Param("bookingDate") Date bookingDate);

    @Query(HibernateQueryLanguage.SERVICES_AVAILABLE_OR_NOT)
    List<Service> findAllAvailableOrNot(@Param("bookingDate") Date bookingDate);

    @Query(HibernateQueryLanguage.SERVICES_AVAILABLE_BY_COMPANY_ID)
    List<Service> findAllAvailable(@Param("bookingDate") Date bookingDate, @Param("companyId") Long companyId);

    @Query(HibernateQueryLanguage.SERVICES_AVAILABLE_OR_NOT_BY_COMPANY_ID)
    List<Service> findAllAvailableOrNot(@Param("bookingDate") Date bookingDate, @Param("companyId") Long companyId);

    @Query(HibernateQueryLanguage.IS_SERVICE_AVAILABLE_BY_ID_AND_BOOKING_DATE)
    boolean isAvailableByIdAndDate(@Param("serviceId") Long serviceId, @Param("bookingDate") Date bookingDate);

    Optional<Service> findByIdAndCompany(Long id, Company company);
}
