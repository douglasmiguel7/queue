package com.github.douglasmiguel7.queue.api;

import com.github.douglasmiguel7.queue.domain.Booking;
import com.github.douglasmiguel7.queue.input.BookingInput;
import com.github.douglasmiguel7.queue.mapper.BookingMapper;
import com.github.douglasmiguel7.queue.output.BookingOutput;
import com.github.douglasmiguel7.queue.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BookingAPI extends AbstractBaseV1API {

    private final BookingRepository bookingRepository;

    private final BookingMapper bookingMapper;

    @Autowired
    public BookingAPI(BookingRepository bookingRepository, BookingMapper bookingMapper) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
    }

    @PostMapping("/bookings")
    public ResponseEntity createBooking(@RequestBody @Valid BookingInput bookingInput) {
        System.out.println(bookingInput);



        return ResponseEntity.ok().build();
    }

    @GetMapping("/bookings")
    public ResponseEntity getBookings() {
        List<Booking> bookings = bookingRepository.findAll();

        List<BookingOutput> bookingOutputs = bookingMapper.toOutputs(bookings);

        return ResponseEntity.ok(bookingOutputs);
    }

}
