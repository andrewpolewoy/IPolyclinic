package com.it_academy.jd2.service.user;

import com.it_academy.jd2.model.user.Passport;
import com.it_academy.jd2.service.api.user.IPassportService;
import com.it_academy.jd2.storage.api.people.IPassportRepository;

import java.util.List;

public class PassportService implements IPassportService {

    private IPassportRepository passportRepository;

    public PassportService(IPassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }

    @Override
    public Passport getPassportByFio(String lastName, String firstName, String patronymic, String passportNumber) {
        return passportRepository
                .findByLastNameAndFirstNameAndPatronymicAndNumber(lastName, firstName, patronymic, passportNumber);
    }

    @Override
    public Passport passportNumber(String passportNumber) {
        return passportRepository.findByNumber(passportNumber);
    }

    @Override
    public Passport addPassport(Passport passport) {
        return passportRepository.save(passport);
    }

    @Override
    public List<Passport> getAll() {
        return passportRepository.findAll();
    }

    @Override
    public Passport getPassportById(int id) {
        return passportRepository.findById(id);
    }

    @Override
    public boolean update(Passport passport, int id) {
        Passport passportNew = passportRepository.findById(id);
        passportNew.setSex(passport.getSex());
        passportNew.setExpireDate(passport.getExpireDate());
        passportNew.setCodeOfIssuingState(passport.getCodeOfIssuingState());
        passportNew.setIssueDate(passport.getIssueDate());
        passportNew.setNumber(passport.getNumber());
        passportNew.setPatronymic(passport.getPatronymic());
        passportNew.setNationality(passport.getNationality());
        passportNew.setPersonalId(passport.getPersonalId());
        passportNew.setDateOfBirth(passport.getDateOfBirth());
        passportNew.setLastName(passport.getLastName());
        passportNew.setFirstName(passport.getFirstName());
        Passport passportSaved = passportRepository.save(passportNew);
        if(passportSaved.equals(passportNew)){
            return true;
        } else return false;
    }

    @Override
    public boolean delete(int id) {
        Passport passport = passportRepository.findById(id);
        if (passport == null) {
            return false;
        } else {
            passportRepository.delete(passport);
            return true;
        }
    }

    @Override
    public Passport getByUserId(int id) {
        return passportRepository.findByUserId(id);
    }
}
//    public Passport createPassport(Passport passport, Map<String, Object> map, User user) {
//        passport.setPassport_id((String) map.get("passport_id"));
//        passport.setPassportNumber((String) map.get("passport_number"));
////        passport.setIdentification((String) map.get("identification"));
//        passport.setCodeOfIssuingState((String) map.get("codeOfIssuingState"));
//        passport.setNationality((String) map.get("nationality"));
//        passport.setBirthDate(LocalDate.parse((String) map.get("birth_date")));
//        passport.setbirth_place((String) map.get("birth_place"));
//        passport.setDateOfIssue(LocalDate.parse((String) map.get("date_of_issue")));
//        passport.setDateOfExpiry(LocalDate.parse((String) map.get("date_of_expiry")));
//        passport.setSex(Sex.valueOf((String) map.get("sex")));
//        passport.setUser(user);
