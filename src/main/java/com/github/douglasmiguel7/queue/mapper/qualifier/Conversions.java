package com.github.douglasmiguel7.queue.mapper.qualifier;

import com.github.douglasmiguel7.queue.domain.Domain;
import com.github.douglasmiguel7.queue.utils.Formatters;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Convertion
public class Conversions {

    @ToLong
    public Long toLong(Domain domain) {
        return domain != null ? domain.getId() : null;
    }

    @ToTime
    public String toTime(Date date) {
        return Formatters.toTime(date);
    }

    @ToDate
    public String toDate(Date date) {
        return Formatters.toDate(date);
    }

    @ToTimestamp
    public String toTimestamp(Date date) {
        return Formatters.toTimestamp(date);
    }

}
