/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldOfFri.hra.npc.rozohovor;

import worldOfFri.hra.Hrac;
import worldOfFri.predmety.IPredmet;
import worldOfFri.predmety.Jedlo;

/**
 *
 * @author duracik2
 */
public class OdpovedPredajPredmet extends Odpoved {

    private IPredmet predmet;
    private double cena;
    
    /**
     *
     * @param predmet
     * @param cena
     * @param nasledujucaOtazka
     */
    public OdpovedPredajPredmet(IPredmet predmet, double cena, Otazka nasledujucaOtazka) {
        super(String.format("%s: %.2fe", ucfirst(predmet.getNazov()), cena), nasledujucaOtazka);
        this.predmet = predmet;
        this.cena = cena;
    }

    @Override
    public void vykonaj(Hrac hrac) {
        super.vykonaj(hrac);
        if (hrac.zaplat(this.cena)) {
            hrac.pridajPredmet(this.predmet);
            System.out.println("Nech sa paci, " + this.predmet.getNazov());
        } else {
            System.out.println("Prepac, ale nemas dost penazi");
        }
    }
    
    private static String ucfirst(String str) {
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }
}
