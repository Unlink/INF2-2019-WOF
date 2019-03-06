package worldOfFri.predmety;


import java.time.LocalDateTime;
import worldOfFri.hra.Hrac;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author duracik2
 */
public class Predmet implements IPredmet {

    private final String nazov;

    /**
     *
     * @param nazov
     */
    public Predmet(String nazov) {
        this.nazov = nazov;
    }

    @Override
    public String getNazov() {
        return this.nazov;
    }

    @Override
    public void pouzi(Hrac hrac) {
        System.out.println("Tento predmet neviem pouzit");
    }
}
