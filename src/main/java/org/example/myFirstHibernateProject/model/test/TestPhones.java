package org.example.myFirstHibernateProject.model.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestPhones {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Phones.class)
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
//            session.beginTransaction();
//            User user = new User("User1123");
//            Phones phone = new Phones(222222);
//            phone.setUser(user);
//            List<Phones> phonesList = new ArrayList<>();
//            phonesList.add(phone);
//            user.setPhones(phonesList);
//            session.save(user);
//            session.getTransaction().commit();

//            session.beginTransaction();
//            User user = new User("User1");
//            session.save(user);
//            session.getTransaction().commit();

            session.beginTransaction();
            User entity = session.get(User.class, 1);
           if (entity != null ){
                session.delete(entity);
            }
            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}
