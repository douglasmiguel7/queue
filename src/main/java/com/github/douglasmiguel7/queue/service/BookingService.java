package com.github.douglasmiguel7.queue.service;

import com.github.douglasmiguel7.queue.domain.AppUser;
import com.github.douglasmiguel7.queue.domain.Booking;
import com.github.douglasmiguel7.queue.input.BookingCancelationInput;
import com.github.douglasmiguel7.queue.mapper.BookingMapper;
import com.github.douglasmiguel7.queue.repository.AppUserRepository;
import com.github.douglasmiguel7.queue.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class BookingService {

    private final AppUserRepository appUserRepository;

    private final BookingMapper bookingMapper;

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(AppUserRepository appUserRepository, BookingMapper bookingMapper, BookingRepository bookingRepository) {
        this.appUserRepository = appUserRepository;
        this.bookingMapper = bookingMapper;
        this.bookingRepository = bookingRepository;
    }

    public void cancel(Principal principal, Booking booking, BookingCancelationInput bookingCancelationInput) {
        AppUser appUser = appUserRepository.findOneByName(principal.getName()).get();

        bookingMapper.update(booking, bookingCancelationInput, appUser);

        bookingRepository.save(booking);
    }

}
