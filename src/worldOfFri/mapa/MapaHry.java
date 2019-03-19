package worldOfFri.mapa;


import worldOfFri.predmety.Kocka;
import worldOfFri.predmety.Hodinky;
import worldOfFri.predmety.Predmet;
import java.util.HashMap;
import worldOfFri.hra.npc.Bufetarka;
import worldOfFri.hra.npc.Npc;
import worldOfFri.predmety.Isic;
import worldOfFri.predmety.Jedlo;

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
        this.prepojMiestnostiIsicovimyDverami("terasa", "vratnica");
        
        this.miestnosti.get("terasa").pridajPredmet(new Predmet("pero"));
        this.miestnosti.get("terasa").pridajPredmet(new Hodinky());
        this.miestnosti.get("terasa").pridajPredmet(new Kocka());
        this.miestnosti.get("terasa").pridajPredmet(new Isic());
        this.miestnosti.get("terasa").pridajPredmet(new Jedlo("bageta", 50));
        this.miestnosti.get("terasa").pridajPredmet(new Jedlo("elixir", 100));
        
        this.miestnosti.get("terasa").pridajNpc(new Npc("vratnicka"));
        this.miestnosti.get("terasa").pridajNpc(new Bufetarka());
        this.startovaciaMiestnost = this.miestnosti.get("terasa");
    }

    private void vytvorMiestnost(String nazov, String popis) {
        Miestnost miestnost = new Miestnost(nazov, popis);
        this.miestnosti.put(miestnost.getNazov(), miestnost);
    }
    
    private void prepojMiestnosti(String prva, String druha) {
        Dvere dvere = new Dvere(this.miestnosti.get(druha), this.miestnosti.get(prva));
        
        this.miestnosti.get(prva).nastavVychod(dvere);
        this.miestnosti.get(druha).nastavVychod(dvere);
    }
    
    private void prepojMiestnostiIsicovimyDverami(String prva, String druha) {
        IDvere dvere = new IsicDvere(this.miestnosti.get(druha), this.miestnosti.get(prva));
        
        this.miestnosti.get(prva).nastavVychod(dvere);
        this.miestnosti.get(druha).nastavVychod(dvere);
    }
    
    public Miestnost dajStartovaciuMiestnost() {
        return this.startovaciaMiestnost;
    }
    
}
