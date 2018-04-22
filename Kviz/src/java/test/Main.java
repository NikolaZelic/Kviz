package test;

import baza.DB;
import baza.Korisnik;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Korisnik> list = DB.query("SELECT k FROM Korisnik k");
        for(Korisnik i: list){
            System.out.println(i.getKorUsername());
            System.out.println(i.getKorPassword());
            System.out.println("Cao");
        }
    }
    
}
