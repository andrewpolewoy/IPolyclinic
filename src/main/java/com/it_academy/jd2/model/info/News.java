package com.it_academy.jd2.model.info;

import javax.persistence.*;

/** Сущность новости */
@Entity(name = "News")
@Table(name = "news", schema = "polyclinic")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;                                       //id

    @Column(name = "clinic_info")
    private String  clinic_info;                          //инфо о поликлинике

    @Column(name = "Helpful_information")
    private String helpful_information;                   //Полезная информация
}
