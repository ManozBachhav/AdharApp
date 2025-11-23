package com.Controller;

import com.Service.PersonAdharService;
import com.Service.PersonAdharServiceIMPL;

public class HomeController {
    public static void main(String [] args){
        PersonAdharService pas= new PersonAdharServiceIMPL();
//        pas.addPersonWithAdhar();
//        pas.addPersonWithAdhar();
//        pas.updatePersonDetailonlyUsingPID();
//        pas.updateAdharDetailonlyUsingPID();
//        pas.getAdharOnly();
//        pas.getPersonOnly();
        pas.getallData();
    }
}
