package com.github.douglasmiguel7.queue.output;

public class AppUserOutput {

    private Long id;

    private String nickname;

    private String name;

    private Long companyId;

    private String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AppUserOutput{");
        sb.append("id=").append(id);
        sb.append(", nickname='").append(nickname).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", companyId=").append(companyId);
        sb.append(", role=").append(role);
        sb.append('}');
        return sb.toString();
    }
}
