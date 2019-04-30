package com.github.douglasmiguel7.queue.api;

import com.github.douglasmiguel7.queue.domain.AppUser;
import com.github.douglasmiguel7.queue.domain.Booking;
import com.github.douglasmiguel7.queue.factory.BookingFactory;
import com.github.douglasmiguel7.queue.factory.ErrorFactory;
import com.github.douglasmiguel7.queue.input.BookingCancelationInput;
import com.github.douglasmiguel7.queue.input.BookingInput;
import com.github.douglasmiguel7.queue.mapper.BookingMapper;
import com.github.douglasmiguel7.queue.output.BookingOutput;
import com.github.douglasmiguel7.queue.output.ErrorOutput;
import com.github.douglasmiguel7.queue.search.AppUserSearch;
import com.github.douglasmiguel7.queue.search.BookingSearch;
import com.github.douglasmiguel7.queue.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
public class BookingAPI extends AbstractBaseV1API {

    private final BookingMapper bookingMapper;

    private final BookingFactory bookingFactory;

    private final BookingService bookingService;

    private final BookingSearch bookingSearch;

    private final AppUserSearch appUserSearch;

    @Autowired
    public BookingAPI(BookingMapper bookingMapper, BookingFactory bookingFactory, BookingService bookingService, BookingSearch bookingSearch, AppUserSearch appUserSearch) {
        this.bookingMapper = bookingMapper;
        this.bookingFactory = bookingFactory;
        this.bookingService = bookingService;
        this.bookingSearch = bookingSearch;
        this.appUserSearch = appUserSearch;
    }

    @PostMapping("/bookings")
    public ResponseEntity createBooking(@AuthenticationPrincipal Principal principal, @RequestBody @Valid BookingInput bookingInput) {
        Booking booking = bookingFactory.fabricate(principal, bookingInput);

        BookingOutput bookingOutput = bookingMapper.toOutput(booking);

        return ResponseEntity.status(HttpStatus.CREATED).body(bookingOutput);
    }

    @GetMapping("/bookings")
    public ResponseEntity getBookings(@AuthenticationPrincipal Principal principal) {
        AppUser appUser = appUserSearch.searchByPrincipal(principal);

        List<Booking> bookings = bookingSearch.searchByAppUser(appUser);

        List<BookingOutput> bookingOutputs = bookingMapper.toOutputs(bookings);

        return ResponseEntity.ok(bookingOutputs);
    }

    @DeleteMapping(value = "/bookings/{id}")
    public ResponseEntity cancelBooking(@AuthenticationPrincipal Principal principal, @PathVariable Long id, @RequestBody @Valid BookingCancelationInput bookingCancelationInput) {
        Booking booking = bookingSearch.searchById(id);

        if (booking == null) {
            ErrorOutput errorOutput = ErrorFactory.fabricate("invalid id");

            return ResponseEntity.badRequest().body(errorOutput);
        }

        bookingService.cancel(principal, booking, bookingCancelationInput);

        BookingOutput bookingOutput = bookingMapper.toOutput(booking);

        return ResponseEntity.ok(bookingOutput);
    }

}
