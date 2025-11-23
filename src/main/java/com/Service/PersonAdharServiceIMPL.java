package com.Service;

import com.Entity.Adhar;
import com.Entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.build.AllowSysOut;

import java.sql.SQLOutput;
import java.util.Scanner;

public class PersonAdharServiceIMPL extends PersonAdharService {

    SessionFactory sf = new Configuration().configure("hibernate.cfg.xml")
            .buildSessionFactory();

    @Override
    public void addPersonWithAdhar() {

        Session s = sf.openSession();
        s.beginTransaction();

        Scanner sc = new Scanner(System.in);

        Person p = new Person();

        System.out.println("Enter the person name : ");
        p.setPname(sc.nextLine());     // use nextLine for proper input

        System.out.println("Enter the person address : ");
        p.setPaddress(sc.nextLine());  // you forgot this earlier

        Adhar adhar = new Adhar();
        System.out.println("Enter the adhar number : ");
        adhar.setAdharNumber(sc.nextLine());

        // set relation
        p.setAdhar(adhar);

        // ONLY persist p (cascade will persist adhar automatically)
        s.persist(p);

        s.getTransaction().commit();
        s.close();

        System.out.println("Person added successfully");
    }

    @Override
    public void getPersonOnly() {
        Session s = sf.openSession();
        s.beginTransaction();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter person id: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline

        Person person = s.get(Person.class, id);
        if (person != null) {
            System.out.println("Person found:");
            System.out.println("ID: " + person.getPid());
            System.out.println("Name: " + person.getPname());
            System.out.println("Address: " + person.getPaddress());

            Adhar a = person.getAdhar();
            if (a != null) {
                System.out.println("Adhar ID: " + a.getAid());
                System.out.println("Adhar Number: " + a.getAdharNumber());
            } else {
                System.out.println("No Adhar associated with this person.");
            }

            s.getTransaction().commit();
        } else {
            System.out.println("Invalid person ID!");
            s.getTransaction().rollback();
        }

        s.close();
    }


    @Override
    public void getAdharOnly() {
        Session s = sf.openSession();
        s.beginTransaction();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter adhar id: ");
        int aid = sc.nextInt();
        sc.nextLine();

        Adhar adhar = s.get(Adhar.class, aid);
        if (adhar != null) {
            System.out.println("Adhar found:");
            System.out.println("ID: " + adhar.getAid());
            System.out.println("Number: " + adhar.getAdharNumber());
            // If Adhar had a Person reference (bidirectional), you could print it here.
            s.getTransaction().commit();
        } else {
            System.out.println("Invalid adhar ID!");
            s.getTransaction().rollback();
        }

        s.close();
    }


    @Override
    public void getallData() {
        Session s = sf.openSession();
        s.beginTransaction();

        // Fetch all persons and print their adhar (if any)
        @SuppressWarnings("unchecked")
        java.util.List<Person> list = s.createQuery("from Person").list();

        if (list.isEmpty()) {
            System.out.println("No persons found.");
        } else {
            for (Person p : list) {
                System.out.println("-------------");
                System.out.println("Person ID : " + p.getPid());
                System.out.println("Name      : " + p.getPname());
                System.out.println("Address   : " + p.getPaddress());
                Adhar a = p.getAdhar();
                if (a != null) {
                    System.out.println("Adhar ID  : " + a.getAid());
                    System.out.println("Adhar No. : " + a.getAdharNumber());
                } else {
                    System.out.println("Adhar     : none");
                }
            }
        }

        s.getTransaction().commit();
        s.close();
    }


    @Override
    public void updatePersonDetailonlyUsingPID() {

        Session s = sf.openSession();
        s.beginTransaction();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the person Id : ");
        int id = sc.nextInt();
        sc.nextLine(); // IMPORTANT: clear leftover newline

        Person person = s.get(Person.class, id);

        if (person != null) {
            System.out.println("Enter the new person name : ");
            person.setPname(sc.nextLine());

            System.out.println("Enter the new address : ");
            person.setPaddress(sc.nextLine());

            // No persist(), no update() needed — object is already managed
            s.getTransaction().commit();

            System.out.println("Person Updated...");

        } else {
            System.out.println("Invalid person ID!");
            s.getTransaction().rollback();
        }

        s.close();
    }


    @Override
    public void updateAdharDetailonlyUsingPID() {
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter person id (to update its Adhar): ");
        int pid = sc.nextInt();
        sc.nextLine();

        Person person = s.get(Person.class, pid);
        if (person != null) {
            Adhar adhar = person.getAdhar();
            if (adhar != null) {
                System.out.print("Enter new adhar number: ");
                String newNumber = sc.nextLine().trim();
                adhar.setAdharNumber(newNumber);
                // object is managed -> dirty checked at commit
                tx.commit();
                System.out.println("Adhar updated.");
            } else {
                System.out.println("This person has no Adhar to update.");
                tx.rollback();
            }
        } else {
            System.out.println("Invalid person ID!");
            tx.rollback();
        }

        s.close();
    }


    @Override
    public void DeletePersonOnlyUsingPID() {

        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the person Id : ");
        int id = sc.nextInt();

        Person person = s.get(Person.class, id);

        if (person != null) {

            // No need to set adhar null if cascade = ALL
            s.remove(person);

            tx.commit();
            System.out.println("Person deleted!");
        } else {
            System.out.println("Invalid person ID!");
            tx.rollback();
        }

        s.close();
    }


    @Override
    public void DeleteAdharOnlyUsingPID() {
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter person id (to delete its Adhar only): ");
        int pid = sc.nextInt();
        sc.nextLine();

        Person person = s.get(Person.class, pid);
        if (person != null) {
            Adhar adhar = person.getAdhar();
            if (adhar != null) {
                // detach association first (so FK in Person becomes null),
                // then remove the Adhar entity
                person.setAdhar(null);
                s.remove(adhar);
                tx.commit();
                System.out.println("Adhar deleted, Person retained.");
            } else {
                System.out.println("This person has no Adhar to delete.");
                tx.rollback();
            }
        } else {
            System.out.println("Invalid person ID!");
            tx.rollback();
        }

        s.close();
    }

}
