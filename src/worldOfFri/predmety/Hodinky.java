package worldOfFri.predmety;


import java.time.LocalDateTime;
import worldOfFri.hra.Hrac;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Hodinky implements IPredmet {

    @Override
    public String getNazov() {
        return "hodinky";
    }

    @Override
    public void pouzi(Hrac hrac) {
        LocalDateTime aktualnyCas = LocalDateTime.now();
        System.out.println(aktualnyCas.toLocalTime().toString());
    }
    
}
