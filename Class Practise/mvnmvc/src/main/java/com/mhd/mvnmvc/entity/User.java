package com.mhd.mvnmvc.entity;

public class User {
    private Long id;
    private String userName;
    private String mobile;

    public User(Long id, String userName, String mobile) {
        this.id = id;
        this.userName = userName;
        this.mobile = mobile;
    }
}
