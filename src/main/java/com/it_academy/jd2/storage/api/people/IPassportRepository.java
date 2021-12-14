package com.it_academy.jd2.storage.api.people;



import com.it_academy.jd2.model.user.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IPassportRepository extends JpaRepository<Passport, Integer> {

    Passport findByLastNameAndFirstNameAndPatronymicAndNumber(String lastName, String firstName,
                                                              String patronymic, String number);
    Passport findById(int id);

    Passport findByNumber(String number);

    @Query("SELECT p FROM Passport p JOIN p.user u WHERE u.id=?1")
    Passport findByUserId(int id);

}
