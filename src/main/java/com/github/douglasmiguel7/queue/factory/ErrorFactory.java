package com.github.douglasmiguel7.queue.factory;

import com.github.douglasmiguel7.queue.output.ErrorOutput;

public class ErrorFactory {

    private ErrorFactory() {

    }


    public static ErrorOutput fabricate(String errorMessage) {
        return new ErrorOutput(errorMessage);
    }

}
