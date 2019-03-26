/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldOfFri.hra.npc;

import java.util.Scanner;
import worldOfFri.hra.Hrac;
import worldOfFri.hra.npc.rozohovor.Otazka;

/**
 *
 * @author duracik2
 */
public class Npc {

    private final String meno;
    private final Otazka zaciatokRozhovoru;

    public Npc(String meno, Otazka zaciatokRozhovoru) {
        this.meno = meno;
        this.zaciatokRozhovoru = zaciatokRozhovoru;
    }

    public String getMeno() {
        return this.meno;
    }
    
    public void oslov(Hrac hrac) {
        if (this.zaciatokRozhovoru == null) {
            System.out.println("Dobry den");
            return;
        }
        
        Otazka aktualnaOtazka = this.zaciatokRozhovoru;
        Scanner nacitavac = new Scanner(System.in);
        
        do {
            System.out.println(aktualnaOtazka.getTextOtazky());
            aktualnaOtazka.vypisMoznosti();
            int nacitanaHodnota;
            do {
                System.out.print("  > ");
                nacitanaHodnota = nacitavac.nextInt();
            } while (aktualnaOtazka.jeSpravnaMoznost(nacitanaHodnota));
            aktualnaOtazka = aktualnaOtazka.zvolOdpoved(nacitanaHodnota);
        } while (aktualnaOtazka != null);

    }
    
}
