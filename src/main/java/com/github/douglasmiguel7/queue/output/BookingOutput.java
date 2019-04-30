package com.github.douglasmiguel7.queue.output;

public class BookingOutput {

    private Long id;

    private String createdAt;

    private Long serviceId;

    private Long userId;

    private String date;

    private String cancelDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(String cancelDate) {
        this.cancelDate = cancelDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BookingOutput{");
        sb.append("id=").append(id);
        sb.append(", createdAt='").append(createdAt).append('\'');
        sb.append(", serviceId=").append(serviceId);
        sb.append(", userId=").append(userId);
        sb.append(", date='").append(date).append('\'');
        sb.append(", cancelDate='").append(cancelDate).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
