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
public class IsicDvere implements IDvere {

    private final Miestnost prva;
    private final Miestnost druha;
    private boolean otvorene;

    /**
     *
     * @param prva
     * @param druha
     */
    public IsicDvere(Miestnost prva, Miestnost druha) {
        this.prva = prva;
        this.druha = druha;
        this.otvorene = false;
    }
    
    @Override
    public boolean suOtvorene() {
        return this.otvorene;
    }
    
    public void otvor() {
        this.otvorene = true;
    }

    @Override
    public Miestnost dajMiestnost(Miestnost aktualna) {
        if (aktualna == this.druha) return this.prva;
        else return druha;
    }
    
}
