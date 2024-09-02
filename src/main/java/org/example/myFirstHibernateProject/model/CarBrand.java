package org.example.myFirstHibernateProject.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
 @Table(name = "car_brand")
public class CarBrand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, orphanRemoval=true)
    private List<CarModel> carModels = new ArrayList<>();

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

//    public List<CarModel> getCarModels() {
//        return carModels;
//    }
}
