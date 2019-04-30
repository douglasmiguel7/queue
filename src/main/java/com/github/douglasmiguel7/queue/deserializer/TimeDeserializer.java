package com.github.douglasmiguel7.queue.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.github.douglasmiguel7.queue.utils.Formatters;

import java.io.IOException;
import java.util.Date;

public class TimeDeserializer extends StdDeserializer<Date> {

    public TimeDeserializer() {
        this(null);
    }

    public TimeDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return Formatters.fromTime(jsonParser.getText());
    }
}
