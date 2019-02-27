
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author duracik2
 */
public class MapaHry {
    private Miestnost startovaciaMiestnost;
    private HashMap<String, Miestnost> miestnosti;

    public MapaHry() {
        this.startovaciaMiestnost = null;
        this.miestnosti = new HashMap<>();
    }
 
    public void vytvorMiestnosti() {
        this.vytvorMiestnost("terasa", "Terasa pred fakultou");
        this.vytvorMiestnost("vratnica", "Vratnica na FRI");
    
        }

    private void vytvorMiestnost(String nazov, String popis) {
        Miestnost miestnost = new Miestnost(nazov, popis);
        this.miestnosti.put(miestnost.getNazov(), miestnost);
    }
    
    private void prepojMiestnosti(String prva, String druha) {
        this.miestnosti.get(prva).nastavVychod(this.miestnosti.get(druha));
        this.miestnosti.get(druha).nastavVychod(this.miestnosti.get(prva));
    }
    
    public Miestnost dajStartovaciuMiestnost() {
        return this.startovaciaMiestnost;
    }
    
}
