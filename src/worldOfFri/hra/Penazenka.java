/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldOfFri.hra;

import worldOfFri.predmety.IPlatidlo;

/**
 *
 * @author duracik2
 */
public class Penazenka implements IPlatidlo {
    
    private double stav;

    public Penazenka() {
        this(10.0);
    }

    public Penazenka(double stav) {
        this.stav = stav;
    }
    
    @Override
    public double getStav() {
        return this.stav;
    }

    @Override
    public boolean zaplat(double ciastka) {
        if (this.stav < ciastka) {
            return false;
        }
        this.stav -= ciastka;
        return true;
    }

    @Override
    public void pridajPeniaze(double ciastka) {
        this.stav += ciastka;
    }
}
