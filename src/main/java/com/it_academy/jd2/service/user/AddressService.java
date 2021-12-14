package com.it_academy.jd2.service.user;

import com.it_academy.jd2.model.user.Address;
import com.it_academy.jd2.model.user.User;
import com.it_academy.jd2.service.api.user.IAddressService;
import com.it_academy.jd2.storage.api.people.IAddressRepository;

import java.util.List;

public class AddressService implements IAddressService {

    IAddressRepository addressRepository;

    public AddressService(IAddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public void addAddress(Address address) {
        addressRepository.save(address);
    }

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address getAddressById(int id) {
        return addressRepository.findById(id);
    }

    @Override
    public boolean update(Address address, int id) {
        Address addressNew = addressRepository.findById(id);
        addressNew.setIndex(address.getIndex());
        addressNew.setApartmentNumber(address.getApartmentNumber());
        addressNew.setStreet(address.getStreet());
        addressNew.setHouseNumber(address.getHouseNumber());
        addressNew.setCity(address.getCity());
        addressNew.setRegion(addressNew.getRegion());
        addressNew.setCountry(address.getCountry());
        addressNew.setId(address.getId());
        Address addressSaved = addressRepository.save(addressNew);
        if(addressSaved.equals(addressNew)){
            return true;
        } else return false;
    }

    @Override
    public boolean delete(int id) {
        Address address = addressRepository.findById(id);
        if(address == null){
            return false;
        } else {
            addressRepository.delete(address);
            return true;
        }
    }

    @Override
    public Address getByUser(User user) {
        return addressRepository.findByUser(user);
    }
}

