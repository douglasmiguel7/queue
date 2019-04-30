package com.github.douglasmiguel7.queue.mapper;

import com.github.douglasmiguel7.queue.domain.Booking;
import com.github.douglasmiguel7.queue.input.BookingInput;
import com.github.douglasmiguel7.queue.mapper.qualifier.Conversions;
import com.github.douglasmiguel7.queue.mapper.qualifier.Convertion;
import com.github.douglasmiguel7.queue.mapper.qualifier.ToLong;
import com.github.douglasmiguel7.queue.mapper.qualifier.ToTimestamp;
import com.github.douglasmiguel7.queue.output.BookingOutput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {Conversions.class, ServiceMapper.class})
public interface BookingMapper {

    @Mapping(target = "createdAt", source = "createdAt", qualifiedBy = {Convertion.class, ToTimestamp.class})
    @Mapping(target = "userId", source = "appUser", qualifiedBy = {Convertion.class, ToLong.class})
    @Mapping(target = "serviceId", source = "service", qualifiedBy = {Convertion.class, ToLong.class})
    BookingOutput toOutput(Booking service);

    List<BookingOutput> toOutputs(List<Booking> bookings);

    @Mapping(target = "service", source = "serviceId")
    Booking toBooking(BookingInput bookingInput);
}
