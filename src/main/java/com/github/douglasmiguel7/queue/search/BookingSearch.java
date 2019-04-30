package com.github.douglasmiguel7.queue.search;

import com.github.douglasmiguel7.queue.domain.AppUser;
import com.github.douglasmiguel7.queue.domain.Booking;
import com.github.douglasmiguel7.queue.hardcode.AppUserRole;
import com.github.douglasmiguel7.queue.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BookingSearch {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingSearch(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking searchByIdAndAppUser(Long id, AppUser appUser) {
        if (id == null || Long.valueOf(0).equals(id)) {
            return null;
        }

        Optional<Booking> optionalBooking = Optional.empty();

        if (AppUserRole.EMPLOYEE.equals(appUser.getRole())) {
            optionalBooking = bookingRepository.findByIdAndService_Company(id, appUser.getCompany());
        } else if (AppUserRole.CUSTOMER.equals(appUser.getRole())) {
            optionalBooking = bookingRepository.findByIdAndAppUser(id, appUser);
        } else if (AppUserRole.ADMIN.equals(appUser.getRole())) {
            optionalBooking = bookingRepository.findById(id);
        }

        if (!optionalBooking.isPresent()) {
            return null;
        }

        return optionalBooking.get();
    }

    public List<Booking> searchByAppUser(AppUser appUser) {
        if (appUser == null) {
            return Collections.emptyList();
        }

        if (AppUserRole.CUSTOMER.equals(appUser.getRole())) {
            return bookingRepository.findAllByAppUser(appUser);
        } else if (AppUserRole.EMPLOYEE.equals(appUser.getRole())) {
            return bookingRepository.findAllByService_Company(appUser.getCompany());
        } else {
            return bookingRepository.findAll();
        }
    }
}
