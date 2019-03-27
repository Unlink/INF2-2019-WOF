/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldOfFri.hra.npc.rozohovor;

import worldOfFri.hra.Hrac;

/**
 *
 * @author duracik2
 */
public class OtazkaDobitieIsic implements IOtazka {

    private static int[] moznosti = {1, 2, 5, 10, 15, 20};
    private final IOtazka otazka;

    public OtazkaDobitieIsic(IOtazka otazka) {
        this.otazka = otazka;
    }
    
    
    
    @Override
    public String getTextOtazky() {
        return "Za kolko?";
    }

    @Override
    public boolean jeSpravnaMoznost(int nacitanaHodnota) {
        return true;
    }

    @Override
    public void vypisMoznosti(Hrac hrac) {
        double stavPenazenky = hrac.dajStavPenazenky();
        for (int i = 0; i < moznosti.length; i++) {
            if (moznosti[i] <= stavPenazenky) {
                System.out.println((i+1)+" "+moznosti[i]);
            }
        }
    }

    @Override
    public IOtazka zvolOdpoved(int nacitanaHodnota, Hrac hrac) {
        if (nacitanaHodnota == 0) {
            return null;
        }
        else {
            
            //premiestni peniaze
            //TODO
            return otazka;
        }
    }
    
}
