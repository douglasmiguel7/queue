package com.github.douglasmiguel7.queue.factory;

import com.github.douglasmiguel7.queue.domain.AppUser;
import com.github.douglasmiguel7.queue.domain.Booking;
import com.github.douglasmiguel7.queue.input.BookingInput;
import com.github.douglasmiguel7.queue.mapper.BookingMapper;
import com.github.douglasmiguel7.queue.repository.AppUserRepository;
import com.github.douglasmiguel7.queue.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookingFactory {

    private final BookingMapper bookingMapper;

    private final AppUserRepository appUserRepository;

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingFactory(BookingMapper bookingMapper, AppUserRepository appUserRepository, BookingRepository bookingRepository) {
        this.bookingMapper = bookingMapper;
        this.appUserRepository = appUserRepository;
        this.bookingRepository = bookingRepository;
    }

    public Booking fabricate(AppUser appUser, BookingInput bookingInput) {
        Booking booking = bookingMapper.toBooking(bookingInput);
        booking.setAppUser(appUser);

        bookingRepository.save(booking);

        return booking;
    }

}
