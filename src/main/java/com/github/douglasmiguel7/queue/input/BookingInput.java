package com.github.douglasmiguel7.queue.input;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class BookingInput {

    @NotNull
    private Long serviceId;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
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
