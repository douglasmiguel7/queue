package com.github.douglasmiguel7.queue.input;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.douglasmiguel7.queue.deserializer.TimeDeserializer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

public class ServiceInput {

    @NotBlank
    private String name;

    private String description;

    private Boolean endless = Boolean.FALSE;

    @NotNull
    @JsonDeserialize(using = TimeDeserializer.class)
    private Date endAt;

    private BigDecimal price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getEndless() {
        return endless;
    }

    public void setEndless(Boolean endless) {
        this.endless = endless;
    }

    public Date getEndAt() {
        return endAt;
    }

    public void setEndAt(Date endAt) {
        this.endAt = endAt;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ServiceInput{");
        sb.append("name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", endless=").append(endless);
        sb.append(", endAt=").append(endAt);
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
