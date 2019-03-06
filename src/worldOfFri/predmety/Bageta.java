/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldOfFri.predmety;

import worldOfFri.hra.Hrac;

/**
 *
 * @author duracik2
 */
public class Bageta implements IPredmet {

    @Override
    public String getNazov() {
        return "bageta";
    }

    @Override
    public void pouzi(Hrac hrac) {
        hrac.zvysEnergiu(50);
        hrac.odstranPredmet(this.getNazov());
    }
    
}
