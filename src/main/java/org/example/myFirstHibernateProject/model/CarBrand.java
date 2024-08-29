package org.example.myFirstHibernateProject.model;

import javax.persistence.*;

@Entity
 @Table(name = "car_brand")
public class CarBrand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    @Column(name = "name")
    private String name;

    public CarBrand() {
    }

    public CarBrand(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
