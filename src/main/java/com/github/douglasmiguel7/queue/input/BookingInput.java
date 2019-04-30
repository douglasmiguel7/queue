package com.github.douglasmiguel7.queue.input;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.douglasmiguel7.queue.serializer.TimestampDeserializer;
import com.github.douglasmiguel7.queue.validator.ValidateBooking;

import java.util.Date;

@ValidateBooking
public class BookingInput {

    private Long serviceId;

    @JsonDeserialize(using = TimestampDeserializer.class)
    private Date date;

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BookingInput{");
        sb.append("serviceId=").append(serviceId);
        sb.append(", date=").append(date);
        sb.append('}');
        return sb.toString();
    }
}
