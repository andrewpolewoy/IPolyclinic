package com.it_academy.jd2.controller.rest;

import com.it_academy.jd2.model.dto.UserPassportAddressWrapper;
import com.it_academy.jd2.model.user.Address;
import com.it_academy.jd2.model.user.Passport;
import com.it_academy.jd2.model.user.User;
import com.it_academy.jd2.service.api.user.IAddressService;
import com.it_academy.jd2.service.api.user.IPassportService;
import com.it_academy.jd2.service.api.user.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserControllerRest {


    private final IUserService userService;

    private final IPassportService passportService;

    private final IAddressService addressService;


    public UserControllerRest(IUserService userService, IPassportService passportService, IAddressService addressService) {
        this.userService = userService;
        this.passportService = passportService;
        this.addressService = addressService;
    }

    @GetMapping
    public ResponseEntity<List<User>> readAll() {
        List<User> users = userService.getAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity <UserPassportAddressWrapper> read(@PathVariable(name = "id") int id) {
        User user = userService.getUserById(id);
        User user1 = new User();
        user1.seteMail(user.geteMail());
        user1.setId(user.getId());
        user1.setPhoneNumber(user.getPhoneNumber());
        user1.setRoles(user.getRoles());
        Passport passport = passportService.getByUserId(user.getId());
        Address address = addressService.getByUser(user);
        UserPassportAddressWrapper wrapper = new UserPassportAddressWrapper();
        wrapper.setUser(user1);
        wrapper.setPassport(passport);
        wrapper.setAddress(address);
        return user != null
                ? new ResponseEntity<>(wrapper, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<User> addUser(User user) {
        User userNew = userService.addUser(user);
        return new ResponseEntity<>(userNew, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody User user) {
        final boolean updated = userService.updatePatient(user, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = userService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
