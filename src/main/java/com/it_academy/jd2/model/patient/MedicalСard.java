package com.it_academy.jd2.model.patient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.it_academy.jd2.model.user.User;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/** Сущность MedicalСard */
@Entity
@Table(name = "medical_card", schema = "polyclinic")
public class MedicalСard implements Serializable, Comparable<MedicalСard>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;                 //id

//    @OneToOne
//    @JoinColumn(name = "patient_id")
////    @JsonIgnore
//    private User patient;               //Пользователь
//
//    @OneToOne
//    @JoinColumn(name = "doctor_id")
//    private User doctor;            //Лечащий врач

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    private String type;
    private String name;
    private String illness;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private LocalDate date;
    private String description;

    @Transient
    private String passport;

    public User getUser() {
        return user;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "MedicalСard{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", illness='" + illness + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", passport='" + passport + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicalСard that = (MedicalСard) o;
        return id == that.id && Objects.equals(user, that.user) && Objects.equals(type, that.type) && Objects.equals(name, that.name) && Objects.equals(illness, that.illness) && Objects.equals(date, that.date) && Objects.equals(description, that.description) && Objects.equals(passport, that.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, type, name, illness, date, description, passport);
    }

    @Override
    public int compareTo(MedicalСard o) {
        return this.date.compareTo(o.getDate());
    }
}
