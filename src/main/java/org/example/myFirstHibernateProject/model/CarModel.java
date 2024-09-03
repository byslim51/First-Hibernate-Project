package org.example.myFirstHibernateProject.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "car_model")
public class CarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private CarBrand brand;

    @ManyToOne
    @JoinColumn(name = "car_body_type_id")
    private CarBodyType bodyType;

    @ManyToOne
    @JoinColumn(name = "car_engine_id")
    private MyCarEngine carEngine;

    @OneToMany(mappedBy = "color", orphanRemoval = true)
    private Set<Car> cars = new HashSet<>();



    public CarModel() {
    }

    public CarModel(String name) {
        this.name = name;
    }

    public CarBrand getBrand() {
        return brand;
    }

    public void setBrand(CarBrand brand) {
        this.brand = brand;
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

    public CarBodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(CarBodyType bodyType) {
        this.bodyType = bodyType;
    }

    public MyCarEngine getCarEngine() {
        return carEngine;
    }

    public void setCarEngine(MyCarEngine carEngine) {
        this.carEngine = carEngine;
    }
}
