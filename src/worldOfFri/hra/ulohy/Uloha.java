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
public abstract class Uloha {

    private final String popis;
    private boolean jeSplnena;

    public Uloha(String popis) {
        this.popis = popis;
        this.jeSplnena = false;
    }

    public String getPopis() {
        return this.popis;
    }

    public boolean isJeSplnena() {
        return this.jeSplnena;
    }

    protected void splnUlohu() {
        this.jeSplnena = true;
        System.out.println(" *** Splnil si ulohu '"+this.popis+"' ***");
    }
    
    public abstract void skontolujSplnenie(Hrac hrac);

    
}
