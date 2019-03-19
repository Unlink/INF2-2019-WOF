/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldOfFri.hra.npc;

import worldOfFri.hra.Hrac;

/**
 *
 * @author duracik2
 */
public class Npc {

    private final String meno;

    public Npc(String meno) {
        this.meno = meno;
    }

    public String getMeno() {
        return this.meno;
    }
    
    public void oslov(Hrac hrac) {
        System.out.println("Dobry den");
    }
    
}
