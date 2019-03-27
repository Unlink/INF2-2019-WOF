/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldOfFri.hra.npc.rozohovor;

import worldOfFri.hra.Hrac;

/**
 *
 * @author duracik2
 */
public interface IOtazka {

    String getTextOtazky();

    boolean jeSpravnaMoznost(int nacitanaHodnota);

    void vypisMoznosti(Hrac hrac);

    IOtazka zvolOdpoved(int nacitanaHodnota, Hrac hrac);
    
}
