package com.github.douglasmiguel7.queue.api;

import com.github.douglasmiguel7.queue.domain.Booking;
import com.github.douglasmiguel7.queue.factory.BookingFactory;
import com.github.douglasmiguel7.queue.input.BookingInput;
import com.github.douglasmiguel7.queue.mapper.BookingMapper;
import com.github.douglasmiguel7.queue.output.BookingOutput;
import com.github.douglasmiguel7.queue.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
public class BookingAPI extends AbstractBaseV1API {

    private final BookingRepository bookingRepository;

    private final BookingMapper bookingMapper;

    private final BookingFactory bookingFactory;

    @Autowired
    public BookingAPI(BookingRepository bookingRepository, BookingMapper bookingMapper, BookingFactory bookingFactory) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
        this.bookingFactory = bookingFactory;
    }

    @PostMapping("/bookings")
    public ResponseEntity createBooking(@AuthenticationPrincipal Principal principal, @RequestBody @Valid BookingInput bookingInput) {
        Booking booking = bookingFactory.fabricate(principal, bookingInput);

        BookingOutput bookingOutput = bookingMapper.toOutput(booking);

        return ResponseEntity.ok(bookingOutput);
    }

    @GetMapping("/bookings")
    public ResponseEntity getBookings() {
        List<Booking> bookings = bookingRepository.findAll();

        List<BookingOutput> bookingOutputs = bookingMapper.toOutputs(bookings);

        return ResponseEntity.ok(bookingOutputs);
    }

}
