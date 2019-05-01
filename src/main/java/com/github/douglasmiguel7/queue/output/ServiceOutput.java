package com.github.douglasmiguel7.queue.output;

import java.math.BigDecimal;

public class ServiceOutput {

    private Long id;

    private String name;

    private String description;

    private Long companyId;

    private Boolean endless;

    private String endAt;

    private BigDecimal price;

    private Boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Boolean getEndless() {
        return endless;
    }

    public void setEndless(Boolean endless) {
        this.endless = endless;
    }

    public String getEndAt() {
        return endAt;
    }

    public void setEndAt(String endAt) {
        this.endAt = endAt;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ServiceOutput{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", companyId=").append(companyId);
        sb.append(", endless=").append(endless);
        sb.append(", endAt='").append(endAt).append('\'');
        sb.append(", price=").append(price);
        sb.append(", active=").append(active);
        sb.append('}');
        return sb.toString();
    }
}
