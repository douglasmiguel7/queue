package com.github.douglasmiguel7.queue.repository;

import com.github.douglasmiguel7.queue.domain.AppUser;
import com.github.douglasmiguel7.queue.domain.Booking;
import com.github.douglasmiguel7.queue.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findAllByAppUser(AppUser appUser);

    List<Booking> findAllByService_Company(Company company);

    Optional<Booking> findByIdAndAppUser(Long id, AppUser appUser);

    Optional<Booking> findByIdAndService_Company(Long id, Company company);
}
