package gui;
import modelo.Manguera;
import javax.swing.*;
import java.awt.*;

public class Ventana  extends JFrame{
    private Container panel;
    private JTextField entrada, volumen,salida;
    private JButton btnEntrada, btnVolumen, btnSalida;
    private JProgressBar barra;
    private Manguera llena;

    public Ventana(){
        super("Lab: Deposito de agua");
        setSize(400,300);
        setLayout(null);
        panel = getContentPane();


        //fila1
        JLabel in = new JLabel("Entrada");
        in.setBounds(5,2,100,30);
        panel.add(in);
        JLabel vol = new JLabel("Volumen");
        vol.setBounds(70,2,100,30);
        panel.add(vol);
        JLabel out = new JLabel("Salida");
        out.setBounds(150,2,100,30);
        panel.add(out);

        //fila2
        entrada = new JTextField("");
        llena = new Manguera("entrada", barra);
        panel.add(entrada);
        volumen = new JTextField("");
        panel.add(volumen);
        salida = new JTextField("");
        panel.add(salida);

        //fila3
        btnEntrada = new JButton("abrir / cerrar");

        panel.add(btnEntrada);
        btnVolumen = new JButton("Actualizar");
        panel.add(btnVolumen);
        btnSalida = new JButton("abrir / cerrar");
        panel.add(btnSalida);

        barra = new JProgressBar(0,100);
        barra.setBounds(1,300,50,290);
        barra.setStringPainted(true);
        barra.setValue(50);
        panel.add(barra);


        setVisible(true);
        btnEntrada.addActionListener(actionEvent ->{
            if(llena.getState() == Thread.State.RUNNABLE){
                try {
                    llena.wait();
                }catch (){

                }
            }
            llena.start();
        });
    }
}
