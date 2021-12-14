package com.it_academy.jd2.service.api.user;

import com.it_academy.jd2.model.user.Address;
import com.it_academy.jd2.model.user.User;

import java.util.List;

public interface IAddressService {
    void addAddress(Address address);
    List<Address> getAll();
    Address getAddressById(int id);
    boolean update(Address address, int id);
    boolean delete(int id);
    Address getByUser(User user);
}
