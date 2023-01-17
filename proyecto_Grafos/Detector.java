package proyecto_Grafos;


import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Detector implements Runnable {

    JTextField entradaDeTexto;
    JLabel palabraRecibida;
    AFD automata;
    public Detector(JTextField entradaDeTexto, JLabel palabraRecibida,AFD automata) {
        this.entradaDeTexto = entradaDeTexto;
        this.palabraRecibida = palabraRecibida;
        this.automata=automata;
    }

    @Override
    public void run() {
        boolean guiño=true;
        while (true) {
            String palabraDeEntradaActual = entradaDeTexto.getText();
            palabraRecibida.setText(palabraDeEntradaActual);
            try {
                if (automata.esPalabraAceptada(palabraDeEntradaActual)) {
                    palabraRecibida.setForeground(Color.WHITE);
                } else {
                    palabraRecibida.setForeground(Color.YELLOW);
                }
            } catch (PalabraInvalidad ex) {
                Logger.getLogger(Detector.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(guiño){
                guiño=false;
                 palabraRecibida.setText(palabraDeEntradaActual+"|");
            }else{
                palabraDeEntradaActual=palabraDeEntradaActual.substring(0, palabraDeEntradaActual.length());
                palabraRecibida.setText(palabraDeEntradaActual);
                guiño=true;
            }
            
            try {
                Thread.sleep(400);
            } catch (InterruptedException ex) {
                Logger.getLogger(Detector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
