package com.bobo.beans;

import com.bobo.pojo.User;

public class UserAndPhoneCode {
    String phonecode;
    User user;

    public UserAndPhoneCode() {
    }

    @Override
    public String toString() {
        return "UserAndPhoneCode{" +
                "phonecode='" + phonecode + '\'' +
                ", user=" + user +
                '}';
    }

    public String getPhonecode() {
        return phonecode;
    }

    public void setPhonecode(String phonecode) {
        this.phonecode = phonecode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserAndPhoneCode(String phonecode, User user) {
        this.phonecode = phonecode;
        this.user = user;
    }
}
