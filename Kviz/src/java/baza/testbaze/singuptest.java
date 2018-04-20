package baza.testbaze;

import baza.DB;

public class singuptest {

    public static void main(String[] args) {
        System.out.println("Pocetak testa SingUp");
        DB.singUpUser("pera", "peric");
        System.out.println("Test SingUp zavrsen");
    }
    
}
