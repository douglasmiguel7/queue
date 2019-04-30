package com.github.douglasmiguel7.queue.output;

public class BookingOutput {

    private Long id;

    private String createdAt;

    private Long serviceId;

    private Long userId;

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BookingOutput{");
        sb.append("id=").append(id);
        sb.append(", createdAt='").append(createdAt).append('\'');
        sb.append(", serviceId=").append(serviceId);
        sb.append(", userId=").append(userId);
        sb.append('}');
        return sb.toString();
    }
}
