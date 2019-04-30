package com.github.douglasmiguel7.queue.repository;

import com.github.douglasmiguel7.queue.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
