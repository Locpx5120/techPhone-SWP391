package models;

import java.util.Date;

public class User {
    private int userId;
    private String fullName;
    private String email;
    private String password;
    private String address;
    private String phone;
    private String avatar;
    private int roleId;
    private boolean active;
    private Date createdDate;

    // Constructors
    public User() {}

    public User(int userId, String fullName, String email, String password, String address, String phone, String avatar, int roleId, boolean active, Date createdDate) {
        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.avatar = avatar;
        this.roleId = roleId;
        this.active = active;
        this.createdDate = createdDate;
    }

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    
    //ToString

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", fullName=" + fullName + ", email=" + email + ", password=" + password + ", address=" + address + ", phone=" + phone + ", avatar=" + avatar + ", roleId=" + roleId + ", active=" + active + ", createdDate=" + createdDate + '}';
    }
    
}
