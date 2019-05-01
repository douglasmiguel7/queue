package com.github.douglasmiguel7.queue.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.github.douglasmiguel7.queue.utils.Formatters;

import java.io.IOException;
import java.util.Date;

public class TimestampDeserializer extends StdDeserializer<Date> {

    public TimestampDeserializer() {
        this(null);
    }

    public TimestampDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return Formatters.fromTimestamp(jsonParser.getText());
    }
}
