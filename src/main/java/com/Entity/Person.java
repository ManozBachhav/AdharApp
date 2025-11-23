package com.Entity;

import jakarta.persistence.*;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int pid;
    private String pname;
    private String paddress;

    @OneToOne(cascade=CascadeType.ALL)
    private Adhar adhar;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPaddress() {
        return paddress;
    }

    public void setPaddress(String paddress) {
        this.paddress = paddress;
    }

    public Adhar getAdhar() {
        return adhar;
    }

    public void setAdhar(Adhar adhar) {
        this.adhar = adhar;
    }

    @Override
    public String toString() {
        return "Person{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", paddress='" + paddress + '\'' +
                ", adhar=" + adhar +
                '}';
    }
}
