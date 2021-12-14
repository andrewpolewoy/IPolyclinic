package com.it_academy.jd2.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.it_academy.jd2.model.user.enums.Sex;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "passports", schema = "polyclinic")
public class Passport implements Comparable<Passport> {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @Column(name = "sex", nullable = true)
//    @Enumerated(EnumType.STRING)
//     private Sex sex;
//
//    @Column(name = "passport_id", nullable = true, unique = true)
//     private String passport_id;
//    @Column(name = "last_name")
//    private String lastName;
//    @Column(name = "first_name")
//    private String firstName;
//    private String patronymic;
//    @OneToOne
//    @JoinColumn(name = "passport_owner ")
//    private User passportOwner;
//    @Column(name = "code_of_issuing_state")
//     private String codeOfIssuingState; //орган выдавший пасспорт
//    @Column(name = "passport_number")
//     private String passportNumber; // номер пасспорта
//     private String nationality; // национальность
//    @Column(name = "birth_date")
//     private LocalDate birthDate; // дата рождения
//    @Column(name = "birth_place")
//     private String birth_place; // место рождения
//    @Column(name = "date_of_issue")
//     private LocalDate dateOfIssue; // дата выдачи пасспорта
//    @Column(name = "date_of_expiry")
//     private LocalDate dateOfExpiry; //окончание срока действия пасспорта
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getPatronymic() {
//        return patronymic;
//    }
//
//    public void setPatronymic(String patronymic) {
//        this.patronymic = patronymic;
//    }
//
//    public User getPassportOwner() {
//        return passportOwner;
//    }
//
//    public void setPassportOwner(User passportOwner) {
//        this.passportOwner = passportOwner;
//    }
//
//    public String getBirth_place() {
//        return birth_place;
//    }
//
//    public void setBirth_place(String birth_place) {
//        this.birth_place = birth_place;
//    }
//
//    public String getCodeOfIssuingState() {
//        return codeOfIssuingState;
//    }
//
//    public void setCodeOfIssuingState(String codeOfIssuingState) {
//        this.codeOfIssuingState = codeOfIssuingState;
//    }
//
//    public String getPassportNumber() {
//        return passportNumber;
//    }
//
//    public void setPassportNumber(String passportNumber) {
//        this.passportNumber = passportNumber;
//    }
//
//    public String getNationality() {
//        return nationality;
//    }
//
//    public void setNationality(String nationality) {
//        this.nationality = nationality;
//    }
//
//    public LocalDate getBirthDate() {
//        return birthDate;
//    }
//
//    public void setBirthDate(LocalDate birthDate) {
//        this.birthDate = birthDate;
//    }
//
//    public String getbirth_place() {
//        return birth_place;
//    }
//
//    public void setbirth_place(String birth_place) {
//        this.birth_place = birth_place;
//    }
//
//    public Sex getSex() {
//        return sex;
//    }
//
//    public void setSex(Sex sex) {
//        this.sex = sex;
//    }
//
//    public LocalDate getDateOfIssue() {
//        return dateOfIssue;
//    }
//
//    public void setDateOfIssue(LocalDate dateOfIssue) {
//        this.dateOfIssue = dateOfIssue;
//    }
//
//    public LocalDate getDateOfExpiry() {
//        return dateOfExpiry;
//    }
//
//    public void setDateOfExpiry(LocalDate dateOfExpiry) {
//        this.dateOfExpiry = dateOfExpiry;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getPassport_id() {
//        return passport_id;
//    }
//
//    public void setPassport_id(String passport_id) {
//        this.passport_id = passport_id;
//    }
//
//    public User getUser() {
//        return passportOwner;
//    }
//
//    public void setUser(User user) {
//        this.passportOwner = user;
//    }
//
//    public Passport() {
//    }
//
//    public Passport(Sex sex, String passport_id, String lastName, String firstName, String patronymic, String codeOfIssuingState, String passportNumber, String nationality, LocalDate birthDate, LocalDate dateOfIssue, LocalDate dateOfExpiry) {
//        this.sex = sex;
//        this.passport_id = passport_id;
//        this.lastName = lastName;
//        this.firstName = firstName;
//        this.patronymic = patronymic;
//        this.codeOfIssuingState = codeOfIssuingState;
//        this.passportNumber = passportNumber;
//        this.nationality = nationality;
//        this.birthDate = birthDate;
//        this.dateOfIssue = dateOfIssue;
//        this.dateOfExpiry = dateOfExpiry;
//    }
//
//    public boolean isPassportHasOwner(Passport passport) {
//        return passport.getUser() != null;
//    }
//}
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int Id;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "first_name")
    private String firstName;
    private String patronymic;
    @Column(name = "code_of_issuing_state")
    private String codeOfIssuingState;
    @Column(unique = true)
    private String number;
    @Column(name = "personal_id")
    private String personalId;
    private String nationality;
    @Column(name = "date_of_birth")
    private String dateOfBirth;
    private String sex;
    @Column(name = "issue_date")
    private String issueDate;
    @Column(name = "expire_date")
    private String expireDate;

    @Transient
    private int userId;

    @OneToOne(mappedBy = "passport")
    @JsonIgnore
    private User user;

    public Passport() {
    }

    public Passport(String lastName, String firstName, String patronymic, String codeOfIssuingState, String number, String personalId, String nationality, String dateOfBirth, String sex, String issueDate, String expireDate) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.codeOfIssuingState = codeOfIssuingState;
        this.number = number;
        this.personalId = personalId;
        this.nationality = nationality;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.issueDate = issueDate;
        this.expireDate = expireDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getCodeOfIssuingState() {
        return codeOfIssuingState;
    }

    public void setCodeOfIssuingState(String codeOfIssuingState) {
        this.codeOfIssuingState = codeOfIssuingState;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public int compareTo(Passport o) {
        return this.lastName.compareTo(o.getLastName());
    }

    @JsonIgnore
    public String getPassportInfo() {
        return lastName + " " + firstName + " " + patronymic + " " + number;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "Id=" + Id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", codeOfIssuingState='" + codeOfIssuingState + '\'' +
                ", number='" + number + '\'' +
                ", personalId='" + personalId + '\'' +
                ", nationality='" + nationality + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", sex='" + sex + '\'' +
                ", issueDate='" + issueDate + '\'' +
                ", expireDate='" + expireDate + '\'' +
                ", userId=" + userId +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Passport passport = (Passport) o;
        return  Objects.equals(getId(), passport.getId()) &&
                Objects.equals(getCodeOfIssuingState(), passport.getCodeOfIssuingState()) &&
                Objects.equals(getDateOfBirth(), passport.getDateOfBirth()) &&
                Objects.equals(getExpireDate(), passport.getExpireDate()) &&
                Objects.equals(getFirstName(), passport.getFirstName()) &&
                Objects.equals(getIssueDate(), passport.getIssueDate()) &&
                Objects.equals(getLastName(), passport.getLastName()) &&
                Objects.equals(getNationality(), passport.getNationality()) &&
                Objects.equals(getNumber(), passport.getNumber()) &&
                Objects.equals(getPatronymic(), passport.getPatronymic()) &&
                Objects.equals(getPersonalId(), passport.getPersonalId()) &&
                Objects.equals(getSex(), passport.getSex());
    }

}
