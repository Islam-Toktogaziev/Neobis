package com.example.AvtoShop.web.dto;


import javax.validation.constraints.Size;

public class UserRegistrationDto {

    @Size (min = 2)
    private String userName;
    private String password;

    public UserRegistrationDto() {
    }

    public UserRegistrationDto(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
