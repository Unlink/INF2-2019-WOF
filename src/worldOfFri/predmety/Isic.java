/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldOfFri.predmety;

import worldOfFri.hra.Hrac;
import worldOfFri.mapa.Dvere;
import worldOfFri.mapa.IDvere;
import worldOfFri.mapa.IsicDvere;
import worldOfFri.mapa.Miestnost;

/**
 *
 * @author duracik2
 */
public class Isic implements IPredmet{

    @Override
    public String getNazov() {
        return "isic";
    }

    @Override
    public void pouzi(Hrac hrac) {
        Miestnost aktualnaMiestnost = hrac.getAktualnaMiestnost();
        for (IDvere dvere: aktualnaMiestnost.dajVsetkyVychody()) {
            if (dvere instanceof IsicDvere) {
                IsicDvere isicDvere = (IsicDvere)dvere;
                isicDvere.otvor();
                System.out.println("Otvoril som dvere do miestnosti: " +
                        dvere.dajMiestnost(aktualnaMiestnost).getNazov());
            }
        }
    }
    
}
