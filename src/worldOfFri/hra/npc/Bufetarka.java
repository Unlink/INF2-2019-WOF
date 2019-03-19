/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldOfFri.hra.npc;

import worldOfFri.hra.Hrac;
import worldOfFri.predmety.Jedlo;

/**
 *
 * @author duracik2
 */
public class Bufetarka extends Npc {
    
    public Bufetarka() {
        super("bufetarka");
    }

    @Override
    public void oslov(Hrac hrac) {
        super.oslov(hrac);
        hrac.pridajPredmet(new Jedlo("bageta", 50));
        System.out.println("Nech sa paci, bageta");
    }
}
