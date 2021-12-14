package com.it_academy.jd2.model.patient;

import com.it_academy.jd2.model.patient.enums.HealthStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "diagnosis", schema = "polyclinic")
public class Diagnosis implements Comparable<Diagnosis>{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "card")
    private MedicalСard card;
    private String prescription;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Column(name = "healthStatus")
    private HealthStatus healthStatus;   //status (здоров или болен)

    public Diagnosis() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MedicalСard getCard() {
        return card;
    }

    public void setMedical_card(MedicalСard card) {
        this.card = card;
    }


    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setCard(MedicalСard card) {
        this.card = card;
    }

    public HealthStatus getStatus() {
        return healthStatus;
    }

    public void setStatus(HealthStatus healthStatus) {
        this.healthStatus = healthStatus;
    }

    @Override
    public String toString() {
        return "Diagnosis{" +
                "id=" + id +
                ", card=" + card +
                ", prescription='" + prescription + '\'' +
                ", date=" + date +
                ", healthStatus=" + healthStatus +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diagnosis diagnosis = (Diagnosis) o;
        return id == diagnosis.id && Objects.equals(card, diagnosis.card) && Objects.equals(prescription, diagnosis.prescription) && Objects.equals(date, diagnosis.date) && healthStatus == diagnosis.healthStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, card, prescription, date, healthStatus);
    }

    @Override
    public int compareTo(Diagnosis o) {
        if (this.getDate().isAfter(o.getDate())) {
            return 1;
        } else if (this.getDate().isBefore(o.getDate())) {
            return -1;
        }
        return 0;
    }

}
