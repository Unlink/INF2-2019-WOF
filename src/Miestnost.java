
import java.util.HashMap;

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
    private HashMap<String, Miestnost> vychody;
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
        this.nazov = nazov;
    }

    public String getNazov() {
        return this.nazov;
    }

    /**
     * Nastavi vychod z miestnosti.
     * @param miestnost
     */
    public void nastavVychod(Miestnost miestnost) {
        this.vychody.put(miestnost.getNazov(), miestnost);
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
        /*for (Miestnost miestnost : this.vychody.values()) {
             System.out.print(miestnost.getNazov() + " ");
        }*/
        System.out.println();
    }

    public Miestnost dajMiestnost(String smer) {
        return this.vychody.get(smer);
    }
    
    
}
