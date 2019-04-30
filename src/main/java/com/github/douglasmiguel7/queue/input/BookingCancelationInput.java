package com.github.douglasmiguel7.queue.input;

import javax.validation.constraints.NotBlank;

public class BookingCancelationInput {

    @NotBlank(message = "type a reason to cancel")
    private String reasonCancel;

    public String getReasonCancel() {
        return reasonCancel;
    }

    public void setReasonCancel(String reasonCancel) {
        this.reasonCancel = reasonCancel;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BookingCancelationInput{");
        sb.append("reasonCancel='").append(reasonCancel).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
