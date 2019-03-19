package worldOfFri.mapa;


import worldOfFri.predmety.IPredmet;
import java.util.HashMap;
import worldOfFri.hra.npc.Npc;

/**
 * Trieda Miestnost realizuje jednu miestnost/priestor v celom priestore hry.
 * Kazda "miestnost" je z inymi miestnostami spojena vychodmi. 
 * Vychody z miestnosti su oznacovane svetovymi stranami sever, vychod, juh
 * a zapad. Pre kazdy vychod si miestnost pamata odkaz na susednu miestnost
 * alebo null, ak tym smerom vychod nema.
 *
 * @author  Michael Kolling, David J. Barnes
 * @version 2006.03.30
 * @author  lokalizacia: Lubomir Sadlon, Jan Janech
 * @version 2012.02.21
 */
public class Miestnost {
    private String popisMiestnosti;
    private HashMap<String, IDvere> vychody;
    private HashMap<String, IPredmet> predmety;
    private HashMap<String, Npc> npc;
    private final String nazov;

    /**
     * Vytvori miestnost popis ktorej je v parametrom.
     * Po vytvoreni miestnost nema ziadne vychody. Popis miesnost strucne 
     * charakterizuje.
     * 
     * @param nazov
     * @param popis text popisu miestnosti.
     */
    public Miestnost(String nazov, String popis) {
        this.popisMiestnosti = popis;
        this.vychody = new HashMap<>();
        this.predmety = new HashMap<>();
        this.npc = new HashMap<>();
        this.nazov = nazov;
    }

    public String getNazov() {
        return this.nazov;
    }

    /**
     * Nastavi vychod z miestnosti.
     * @param dvere
     */
    public void nastavVychod(IDvere dvere) {
        this.vychody.put(dvere.dajMiestnost(this).getNazov(), dvere);
    }
    
    public void pridajPredmet(IPredmet predmet) {
        this.predmety.put(predmet.getNazov(), predmet);
    }

    public void pridajNpc(Npc npc) {
        this.npc.put(npc.getMeno(), npc);
    }
    
    /**
     * @return textovy popis miestnosti.
     */
    public String getPopis() {
        return this.popisMiestnosti;
    }

    public void vypisInfo() {
        System.out.print("Vychody: ");
        for (String kluc : this.vychody.keySet()) {
            System.out.print(kluc + " ");
        }
        System.out.println();
        /*for (Miestnost miestnost : this.vychody.values()) {
             System.out.print(miestnost.getNazov() + " ");
        }*/
        
        System.out.print("Predmety: ");
        for (String kluc : this.predmety.keySet()) {
            System.out.print(kluc + " ");
        }
        System.out.println();
        
        System.out.print("NPC v miestnosti: ");
        for (String kluc : this.npc.keySet()) {
            System.out.print(kluc + " ");
        }
        System.out.println();
    }

    public IDvere dajVychod(String smer) {
        return this.vychody.get(smer);
    }
    
    public Npc dajNpc(String meno) {
        return this.npc.get(meno);
    }

    public IPredmet zodvihniPredmet(String nazov) {
        return this.predmety.remove(nazov);
    }

    public Iterable<IDvere> dajVsetkyVychody() {
        return this.vychody.values();
    }
    
    
}
