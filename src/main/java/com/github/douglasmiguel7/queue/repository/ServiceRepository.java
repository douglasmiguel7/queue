package com.github.douglasmiguel7.queue.repository;

import com.github.douglasmiguel7.queue.domain.Service;
import com.github.douglasmiguel7.queue.hardcode.Queries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Long> {

    @Query(value = Queries.SERVICES_AVAILABLE, nativeQuery = true)
    List<Service> findAvailables(@Param("bookingDate") Date bookingDate);

}
