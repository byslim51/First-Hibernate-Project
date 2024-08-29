package org.example.myFirstHibernateProject.model;

import javax.persistence.*;

@Entity
@Table(name = "car_body_type")
public class CarBodyType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "type")
    private String name;

    public CarBodyType() {
    }

    public CarBodyType(String type) {
        this.name = type;
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
