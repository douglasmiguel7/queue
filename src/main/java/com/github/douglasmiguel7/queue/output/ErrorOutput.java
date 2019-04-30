package com.github.douglasmiguel7.queue.output;

public class ErrorOutput {

    private String error;

    public ErrorOutput() {

    }

    public ErrorOutput(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ErrorOutput{");
        sb.append("error='").append(error).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
