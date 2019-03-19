package worldOfFri.hra;


import worldOfFri.mapa.Miestnost;
import worldOfFri.predmety.IPredmet;
import java.util.HashMap;
import worldOfFri.hra.npc.Npc;
import worldOfFri.mapa.Dvere;
import worldOfFri.mapa.IDvere;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author duracik2
 */
public class Hrac {
    private Miestnost aktualnaMiestnost;
    private HashMap<String, IPredmet> batoh;
    
    private int energia;

    public Hrac(Miestnost startovaciaMiestnost) {
        this.aktualnaMiestnost = startovaciaMiestnost;
        this.batoh = new HashMap<>();
        this.energia = 100; //100%
    }

    public Miestnost getAktualnaMiestnost() {
        return this.aktualnaMiestnost;
    }

    /**
     * Vykona pokus o prechod do miestnosti urcenej danym smerom.
     * Ak je tym smerom vychod, hrac prejde do novej miestnosti.
     * Inak sa vypise chybova sprava do terminaloveho okna.
     * @param prikaz
     * @return 
     */
    public boolean chodDoMiestnosti(Prikaz prikaz) {
        if (!prikaz.maParameter()) {
            // ak prikaz nema parameter - druhe slovo - nevedno kam ist
            System.out.println("Chod kam?");
            return false;
        }
        String smer = prikaz.getParameter();
        // Pokus o opustenie aktualnej miestnosti danym vychodom.
        IDvere dvere = this.aktualnaMiestnost.dajVychod(smer);
        if (dvere == null) {
            System.out.println("Tam nie je vychod!");
        } else if (!dvere.suOtvorene()) {
            System.out.println("Tieto dvere su zatvorene");
        } else {
            this.aktualnaMiestnost = dvere.dajMiestnost(this.aktualnaMiestnost);
            System.out.println("Teraz si v miestnosti " + this.aktualnaMiestnost.getPopis());
            this.aktualnaMiestnost.vypisInfo();
        }
        
        this.energia -= 10;
        if (this.energia <= 0) {
            System.out.println("Nemas dostatok energie - KONIEC HRY");
            return true;
        }
        return false;
    }

    public void vezmiPredmet(Prikaz prikaz) {
        IPredmet predmet = this.aktualnaMiestnost.zodvihniPredmet(prikaz.getParameter());
        if (predmet == null) {
            System.out.println("Tento predmet nieje v miestnosti");
        } else {
            this.batoh.put(predmet.getNazov(), predmet);
            System.out.println("Mas novy predmet - " + predmet.getNazov());
        }
    }

    public void vypisInventar() {
        if (this.batoh.size() > 0) {
            System.out.println("Inventar:");
            for (IPredmet predmet : this.batoh.values()) {
                System.out.println("- " + predmet.getNazov());
            }
        } else {
            System.out.println("Inventar je prazdny");
        }
    }

    public void pouziPredmet(Prikaz prikaz) {
        IPredmet predmet = this.batoh.get(prikaz.getParameter());
        if (predmet == null) {
            System.out.println("Takyto predmet nemas");
        } else {
            predmet.pouzi(this);
        }
    }

    public void vypisStatus() {
        System.out.println("---- Aktualny status hraca ----");
        System.out.println("    Aktualna miestnost: " + this.aktualnaMiestnost.getNazov());
        System.out.println("    Energia: " + this.energia + "%");
    }

    public void zvysEnergiu(int hodnota) {
        this.energia = Math.min(this.energia + hodnota, 100); // 100% je maximum
    }

    public IPredmet odstranPredmet(String nazov) {
        return this.batoh.remove(nazov);
    }

    public void oslovNpc(String parameter) {
        Npc npc = this.aktualnaMiestnost.dajNpc(parameter);
        if (npc == null) {
            System.out.println("Nikto s takymto menom v miestnosti nieje");
        } else {
            npc.oslov(this);
        }
    }
   
}
