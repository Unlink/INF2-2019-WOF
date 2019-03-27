package worldOfFri.mapa;


import worldOfFri.predmety.Kocka;
import worldOfFri.predmety.Hodinky;
import worldOfFri.predmety.Predmet;
import java.util.HashMap;
import worldOfFri.hra.npc.Bufetarka;
import worldOfFri.hra.npc.Npc;
import worldOfFri.hra.npc.rozohovor.Odpoved;
import worldOfFri.hra.npc.rozohovor.OdpovedPredajPredmet;
import worldOfFri.hra.npc.rozohovor.Otazka;
import worldOfFri.hra.npc.rozohovor.OtazkaDobitieIsic;
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
        
        this.miestnosti.get("terasa").pridajNpc(new Npc("vratnicka", this.vytvorDialogPreVratnicku()));
        this.miestnosti.get("terasa").pridajNpc(new Npc("bufetarka", this.vytvorDialogPreBufetarku()));
//        this.miestnosti.get("terasa").pridajNpc(new Bufetarka());
        this.startovaciaMiestnost = this.miestnosti.get("terasa");
    }
    
    private Otazka vytvorDialogPreVratnicku() {
        //Rozhovor pre vratnicku
        //* Dobry den
        //  - Dobry den -> koniec
        //  - Chcel by som kluc 
        //                  * A aky?
        //                     - Od FRA323 -> da mi kluc a koniec
        //                     - Od FRA13 -> da mi kluc a koniec
        //  - Prosim, nepocul som vas -> znova mi zopakuje tento rozhovor
        
        
        Otazka dobry = new Otazka("Dobry den");
        Otazka akyKluc = new Otazka("Aky kluc chcete");
        
        dobry.pridajOdpoved(new Odpoved("Dobry den", null));
        dobry.pridajOdpoved(new Odpoved("Chcel by som kluc", akyKluc));
        dobry.pridajOdpoved(new Odpoved("Prosim, nepocul som vas", dobry));
        
        akyKluc.pridajOdpoved(new Odpoved("Od FRA323", null));
        akyKluc.pridajOdpoved(new Odpoved("Od FRA13", null));
        
        return dobry;
    }
    
    
    private Otazka vytvorDialogPreBufetarku() {
        //Rozhovor pre bufetarku
        //* Dobry den
        //  - Chcel by som nakupit
        //                  * Vyber si
        //                     - Bageta
        //                     - Navleky
        //  - Nabit isic
        //  - Zistit stav na isic
        
        Otazka dobry = new Otazka("Dobry den");
        Otazka nakup = new Otazka("Vyber si");
        
        dobry.pridajOdpoved(new Odpoved("Chcel by som nakupit", nakup));
        dobry.pridajOdpoved(new Odpoved("Nabit isic", new OtazkaDobitieIsic(dobry)));
        dobry.pridajOdpoved(new Odpoved("Zistit stav na isic", dobry));
        
        nakup.pridajOdpoved(new OdpovedPredajPredmet(new Jedlo("bageta", 50), 1.20, dobry));
        nakup.pridajOdpoved(new OdpovedPredajPredmet(new Predmet("navleky"), .30, dobry));
        
        return dobry;
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
