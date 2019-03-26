/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldOfFri.hra.npc.rozohovor;

import java.util.ArrayList;

/**
 * Replika NPC postavy
 * @author duracik2
 */
public class Otazka {

    private final String textOtazky;
    private ArrayList<Odpoved> odpovede;

    public Otazka(String textOtazky) {
        this.textOtazky = textOtazky;
        this.odpovede = new ArrayList<>();
        
    }

    public void pridajOdpoved(Odpoved odpoved) {
        this.odpovede.add(odpoved);
    }
    
    public String getTextOtazky() {
        return textOtazky;
    }

    public void vypisMoznosti() {
        int cislo = 1;
        for (Odpoved odpoved : this.odpovede) {
            System.out.println(" " + (cislo++) + " - " + odpoved.getTextOdpovede());
        }
        System.out.println(" 0 - Koniec");
    }

    public Otazka zvolOdpoved(int nacitanaHodnota) {
        if (nacitanaHodnota == 0) {
            return null;
        }
        else {
            return this.odpovede.get(nacitanaHodnota-1).getNasledujucaOtazka();
        }
    }

    public boolean jeSpravnaMoznost(int nacitanaHodnota) {
        return nacitanaHodnota >= 0 && nacitanaHodnota <= this.odpovede.size();
    }
    
    
    
}
