/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldOfFri.hra.ulohy;

import worldOfFri.hra.Hrac;

/**
 *
 * @author duracik2
 */
public class UlohaZiskajPredmet extends Uloha {

    private String nazovPredmetu;
    
    public UlohaZiskajPredmet(String nazovPredmetu) {
        super("Ziskaj predmet "+nazovPredmetu);
        this.nazovPredmetu = nazovPredmetu;
    }

    @Override
    public void skontolujSplnenie(Hrac hrac) {
        if (hrac.dajPredmet(nazovPredmetu) != null) {
            this.splnUlohu();
        }
    }   
}
