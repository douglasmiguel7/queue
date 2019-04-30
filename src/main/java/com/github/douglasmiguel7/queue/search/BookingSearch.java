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

        if (appUser.getRole().equals(AppUserRole.EMPLOYEE)) {
            optionalBooking = bookingRepository.findByIdAndService_Company(id, appUser.getCompany());
        } else if (appUser.getRole().equals(AppUserRole.CUSTOMER)) {
            optionalBooking = bookingRepository.findByIdAndAppUser(id, appUser);
        } else if (appUser.getRole().equals(AppUserRole.ADMIN)) {
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

        if (appUser.getRole().equals(AppUserRole.CUSTOMER)) {
            return bookingRepository.findAllByAppUser(appUser);
        } else if (appUser.getRole().equals(AppUserRole.EMPLOYEE)) {
            return bookingRepository.findAllByService_Company(appUser.getCompany());
        } else {
            return bookingRepository.findAll();
        }
    }
}
