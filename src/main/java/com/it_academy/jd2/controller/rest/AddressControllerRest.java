package com.it_academy.jd2.controller.rest;

import com.it_academy.jd2.model.user.Address;
import com.it_academy.jd2.model.user.User;
import com.it_academy.jd2.service.api.user.IAddressService;
import com.it_academy.jd2.service.api.user.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressControllerRest {


    private final IAddressService addressService;
    private final IUserService userService;


    public AddressControllerRest(IAddressService addressService, IUserService userService) {
        this.addressService = addressService;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<Address>> readAll() {
        List<Address> addresses = addressService.getAll();
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> read(@PathVariable(name = "id") int id) {
        Address address = addressService.getAddressById(id);

        return address != null
                ? new ResponseEntity<>(address, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Address> add(Address address) {
        User user = userService.getUserById(address.getUserId());
        if(user.getRegistrationAddress() != null){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        } else {
            Address addressNew = new Address(address.getCountry(), address.getRegion(),
                    address.getCity(), address.getStreet(), address.getHouseNumber(),
                    address.getApartmentNumber(), address.getIndex());
            user.setRegistrationAddress(addressNew);
            addressService.addAddress(addressNew);
            userService.updateAddress(user, address.getUserId());
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Address address) {
        final boolean updated = addressService.update(address, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = addressService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
