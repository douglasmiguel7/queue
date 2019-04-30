package com.github.douglasmiguel7.queue.service;

import com.github.douglasmiguel7.queue.domain.AppUser;
import com.github.douglasmiguel7.queue.domain.Booking;
import com.github.douglasmiguel7.queue.input.BookingCancelationInput;
import com.github.douglasmiguel7.queue.mapper.BookingMapper;
import com.github.douglasmiguel7.queue.repository.AppUserRepository;
import com.github.douglasmiguel7.queue.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void cancel(AppUser appUser, Booking booking, BookingCancelationInput bookingCancelationInput) {
        bookingMapper.update(booking, bookingCancelationInput, appUser);

        bookingRepository.save(booking);
    }

}
