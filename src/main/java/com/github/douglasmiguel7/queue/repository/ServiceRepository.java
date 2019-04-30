package com.github.douglasmiguel7.queue.repository;

import com.github.douglasmiguel7.queue.domain.Service;
import com.github.douglasmiguel7.queue.hardcode.HibernateQueryLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Long> {

    @Query(HibernateQueryLanguage.SERVICES_AVAILABLE)
    List<Service> findAvailables(@Param("bookingDate") Date bookingDate);

    @Query(HibernateQueryLanguage.SERVICES_AVAILABLE_BY_COMPANY)
    List<Service> findAvailables(@Param("bookingDate") Date bookingDate, @Param("companyId") Long companyId);
}
