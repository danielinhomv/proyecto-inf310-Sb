package proyecto_Grafos;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Lenguaje {

    public List<Character> alfabeto;
    public List<String> lenguaje;

    public Lenguaje(Lenguaje otroLenguaje) {
        alfabeto = new ArrayList<>();
        lenguaje = new ArrayList<>();
        for (char simbolo : otroLenguaje.alfabeto) {
            alfabeto.add(simbolo);
        }
        for (String palabraEnTurno : otroLenguaje.lenguaje) {
            lenguaje.add(palabraEnTurno);
        }
    }

    public Lenguaje(List<Character> alfabeto, List<String> lenguaje) throws AlfabetoInvalido, PalabraInvalidad {
        this.alfabeto = alfabeto;
        this.lenguaje = lenguaje;
        validarAlfabeto(this.alfabeto);
        validarLenguaje(this.lenguaje);
    }

    public List<Character> getAlfabeto() {
        return alfabeto;
    }

    public List<String> getPalabra() {
        return lenguaje;
    }

    public void validarPalabra(String palabraAValidar) throws PalabraInvalidad {
        for (int i = 0; i < palabraAValidar.length(); i++) {
            if (!alfabeto.contains(palabraAValidar.charAt(i))) {
                throw new PalabraInvalidad();
            }
        }
    }

    private void validarAlfabeto(List<Character> alfabetoAValidar) throws AlfabetoInvalido {
        if (alfabetoAValidar.isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("el alfabeto no puede ser vacio");
        }
        for (char simbolo : alfabetoAValidar) {
            if (simbolo == ' ') {
                throw new AlfabetoInvalido();
            }
        }
    }

    private void validarLenguaje(List<String> lenguajeAValidar) throws PalabraInvalidad {
        for (String palabra : lenguajeAValidar) {
            validarPalabra(palabra);
        }
    }

    public void adicionarPalabra(String nuevaPalabra) throws PalabraInvalidad {
        validarPalabra(nuevaPalabra);
        if (!lenguaje.contains(nuevaPalabra)) {
            lenguaje.add(nuevaPalabra);
        } else {
            JOptionPane.showMessageDialog(null, "palabra ya existe");
        }
    }

    public int cantidadDePalabras() {
        return lenguaje.size();
    }

    public void actualizar(int posicion, String nuevaPalabra) {
        if (posicion >= 0 && posicion < cantidadDePalabras()) {
            lenguaje.set(posicion, nuevaPalabra);
        }
    }

}
