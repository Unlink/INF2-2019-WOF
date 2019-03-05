
import java.time.LocalDateTime;

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
    public void pouzi() {
        LocalDateTime aktualnyCas = LocalDateTime.now();
        System.out.println(aktualnyCas.toLocalTime().toString());
    }
    
}
