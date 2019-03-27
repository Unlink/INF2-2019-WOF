/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldOfFri.hra.npc.rozohovor;

import worldOfFri.hra.Hrac;

/**
 * Odpoved hraca
 * @author duracik2
 */
public class Odpoved {

    private final String textOdpovede;
    private final IOtazka nasledujucaOtazka;

    public Odpoved(String textOdpovede, IOtazka nasledujucaOtazka) {
        this.textOdpovede = textOdpovede;
        this.nasledujucaOtazka = nasledujucaOtazka;
    }

    public String getTextOdpovede() {
        return textOdpovede;
    }

    public IOtazka getNasledujucaOtazka() {
        return nasledujucaOtazka;
    }
    
    public void vykonaj(Hrac hrac) {
        
    }
    
}
