package org.example.myFirstHibernateProject.model.test;

import javax.persistence.*;

@Entity
@Table
public class Phones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    Также надо было добавить ManyToOne и @JoinColumn вот сюда
    @ManyToOne
    @JoinColumn(name = "user_id")
//    @Column(name = "user_id")
    private User user;

    private int number;

    public Phones() {
    }

    public Phones(int number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
