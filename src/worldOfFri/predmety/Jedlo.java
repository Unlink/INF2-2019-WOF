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
public class Jedlo implements IPredmet {

    private final String nazov;
    private final int energetickaHodnota;

    /**
     *
     * @param nazov
     * @param energetickaHodnota
     */
    public Jedlo(String nazov, int energetickaHodnota) {
        this.nazov = nazov;
        this.energetickaHodnota = energetickaHodnota;
    }
    
    @Override
    public String getNazov() {
        return this.nazov;
    }

    @Override
    public void pouzi(Hrac hrac) {
        hrac.zvysEnergiu(this.energetickaHodnota);
        hrac.odstranPredmet(this.getNazov());
    }
    
}
