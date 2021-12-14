package com.it_academy.jd2.controller.rest;

import com.it_academy.jd2.model.patient.MedicalСard;
import com.it_academy.jd2.model.user.Passport;
import com.it_academy.jd2.model.user.User;
import com.it_academy.jd2.service.api.patient.IMedicalCardService;
import com.it_academy.jd2.service.api.user.IPassportService;
import com.it_academy.jd2.service.api.user.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.TreeSet;

@RestController
@RequestMapping("/medical_card")
public class MedicalCardControllerRest {


    private final IMedicalCardService medicalCardService;
    private final IUserService userService;
    private final IPassportService passportService;

    public MedicalCardControllerRest(IMedicalCardService medicalCardService, IUserService userService, IPassportService passportService) {
        this.medicalCardService = medicalCardService;
        this.userService = userService;
        this.passportService = passportService;
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<TreeSet<MedicalСard>> readAllByUserId(@PathVariable(name = "id") int userId) {
        TreeSet<MedicalСard> medicalCards = medicalCardService.getAllByUserId(userId);
        return new ResponseEntity<>(medicalCards, HttpStatus.OK);
    }



    @GetMapping("/{id}")
    public ResponseEntity<MedicalСard> read(@PathVariable(name = "id") int id) {
        final MedicalСard medicalCard = medicalCardService.getNoteById(id);

        return medicalCard != null
                ? new ResponseEntity<>(medicalCard, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<MedicalСard> addUser(MedicalСard medicalCard) {
        String passportNumber = medicalCard.getPassport();
        Passport passport = passportService.passportNumber(passportNumber);
        User user = userService.getUserByPassport(passport);
        medicalCard.setUser(user);
        medicalCardService.addMedicalСard(medicalCard);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody MedicalСard medicalCard) {
        final boolean updated = medicalCardService.update(medicalCard, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = medicalCardService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }



}
