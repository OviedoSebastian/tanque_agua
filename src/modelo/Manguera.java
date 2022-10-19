package modelo;
import javax.swing.*;

public class Manguera extends Thread {

    public Manguera(String nombre, JProgressBar barra){
        Super(nombre);
        this.barra=barra;
    }

    public void run(){

        for(int i=0; i<100;i++){
            barra.setvalue(1);
            try {
                sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }
}
