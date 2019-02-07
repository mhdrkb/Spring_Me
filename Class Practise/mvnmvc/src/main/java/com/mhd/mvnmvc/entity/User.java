package com.mhd.mvnmvc.entity;

import java.util.Objects;

public class User {
    private Long id;
    private String userName;
    private String mobile;

    public User(Long id, String userName, String mobile) {
        this.id = id;
        this.userName = userName;
        this.mobile = mobile;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId()) &&
                Objects.equals(getUserName(), user.getUserName()) &&
                Objects.equals(getMobile(), user.getMobile());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserName(), getMobile());
    }

}
