package com.github.douglasmiguel7.queue.mapper;

import org.mapstruct.Mapper;

import java.text.SimpleDateFormat;
import java.util.Date;

@Mapper(componentModel = "spring")
public interface DateMapper {

    default String asString(Date date) {
        return date != null ? new SimpleDateFormat("HH:mm").format(date) : null;
    }

}
