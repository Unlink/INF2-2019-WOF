
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
        String[][] miestnosti = new String[][] {
            {"terasa", "Terasa pred fakultou"},
            {"vratnica", "Vratnica fakulty FRI"},
            {"chodba", "chodba"},
            {"chodbaA", "chodba na acku"},
            {"chodbaB", "chodba na becku"},
            {"jedalen", "jedalen"},
            {"bufet", "bufet"},
            {"a12", "a12"},
            {"a6", "a6"},
            {"wc", "toaleta"}
        };
        
        String[][] dvere = new String[][] {
            {"terasa", "vratnica"},
            {"chodba", "vratnica"},
            {"chodba", "wc"},
            {"chodba", "jedalen"},
            {"chodba", "chodbaA"},
            {"chodba", "chodbaB"},
            {"chodbaA", "a12"},
            {"chodbaA", "a6"},
            {"jedalen", "bufet"},
        };
        
        for (String[] miestnost : miestnosti) {
            this.vytvorMiestnost(miestnost[0], miestnost[1]);
        }
    
        for (String[] prechod : dvere) {
            this.prepojMiestnosti(prechod[0], prechod[1]);
        }
        
        this.miestnosti.get("terasa").pridajPredmet(new Predmet("pero"));
        this.miestnosti.get("terasa").pridajPredmet(new Hodinky());
        
        this.startovaciaMiestnost = this.miestnosti.get("terasa");
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
