/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldOfFri.mapa;

/**
 *
 * @author duracik2
 */
public class Dvere {

    private final Miestnost prva;
    private final Miestnost druha;

    /**
     *
     * @param prva
     * @param druha
     */
    public Dvere(Miestnost prva, Miestnost druha) {
        this.prva = prva;
        this.druha = druha;
    }
    
    public boolean suOtvorene() {
        return true;
    }

    public Miestnost dajMiestnost(Miestnost aktualna) {
        if (aktualna == this.druha) return this.prva;
        else return druha;
    }
    
}