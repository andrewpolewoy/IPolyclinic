package com.it_academy.jd2.model.dto;

import com.it_academy.jd2.model.user.Address;
import com.it_academy.jd2.model.user.Passport;
import com.it_academy.jd2.model.user.User;

public class UserPassportAddressWrapper {
    private User user;
    private Passport passport;
    private Address address;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserPassportAddressWrapper{" +
                "user=" + user +
                ", passport=" + passport +
                ", address=" + address +
                '}';
    }
}
