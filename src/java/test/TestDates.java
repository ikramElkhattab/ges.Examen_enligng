package test;

import dao.EtudiantDao;
import entites.Etudiant;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class TestDates {
    public static void main(String[] args) {
         
        EtudiantDao ed = new EtudiantDao();
        for(Etudiant e : ed.findBetweenDate(new Date("2002/03/01"), new Date("2010/03/01")))
            System.out.println(e.getNom());
    }
}