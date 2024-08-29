package org.example.myFirstHibernateProject.model;

import javax.persistence.*;

@Entity
@Table(name = "car_engine")
public class MyCarEngine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "model")
    private String name;

    public MyCarEngine(String name) {
        this.name = name;
    }

    public MyCarEngine() {
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
