package worldOfFri.predmety;

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
public class Kocka implements IPredmet {

    @Override
    public String getNazov() {
        return "kocka";
    }

    @Override
    public void pouzi(Hrac hrac) {
        System.out.println(((int)(Math.random()*6)) + 1);
    }
    
}
