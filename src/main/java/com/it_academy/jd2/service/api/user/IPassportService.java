package com.it_academy.jd2.service.api.user;

import com.it_academy.jd2.model.user.Passport;

import java.util.List;

public interface IPassportService {
    Passport getPassportByFio(String lastName, String firstName, String patronymic, String passportNumber);
    Passport passportNumber(String number);
    Passport addPassport(Passport passport);
    List<Passport> getAll();
    Passport getPassportById(int id);
    boolean update(Passport passport, int id);
    boolean delete(int id);
    Passport getByUserId(int id);
}
