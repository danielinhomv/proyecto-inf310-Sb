package proyecto_Grafos;

import java.util.*;

public class AFD {

    public GrafoPesado miGrafo;
    public List<Integer> estadosFinales;
    public int estadoInicial;
    public Lenguaje miLenguaje;

    public AFD(Lenguaje otroLenguaje) {
        miLenguaje = otroLenguaje;
        miGrafo = new GrafoPesado();
        estadosFinales = new ArrayList<>();
        generarAFD();
    }

    private void generarAFD() {
        miGrafo.insertarVertice();
        estadoInicial = 0;
        List<String> Lenguaje = miLenguaje.lenguaje;
        for (String palabraEnTurno : Lenguaje) {
            if (miGrafo.cantidadDeAristas() == 0) {
                for (int i = 0; i < palabraEnTurno.length(); i++) {
                    miGrafo.insertarVertice();
                    miGrafo.insertarArista(i, i + 1, palabraEnTurno.charAt(i));
                }
                estadosFinales.add(miGrafo.cantidadDeVertices() - 1);
            } else {
                int indiceDeVerticeActual = estadoInicial;
                for (int i = 0; i < palabraEnTurno.length(); i++) {
                    List<AdyacenteConPeso> listaDeAdyacenciaDelEstadoActual = miGrafo.listaDeAdyacencia.get(indiceDeVerticeActual);
                    int verticeDestino = ObtenerVerticeDestinoDeLPeso(listaDeAdyacenciaDelEstadoActual, palabraEnTurno.charAt(i));
                    AdyacenteConPeso adyacenteConPesoDelSimboloActual = new AdyacenteConPeso(verticeDestino, palabraEnTurno.charAt(i));
                    if (listaDeAdyacenciaDelEstadoActual.contains(adyacenteConPesoDelSimboloActual)) {
                        indiceDeVerticeActual = verticeDestino;
                    } else {
                        miGrafo.insertarVertice();
                        miGrafo.insertarArista(indiceDeVerticeActual, miGrafo.cantidadDeVertices() - 1, palabraEnTurno.charAt(i));
                        indiceDeVerticeActual = miGrafo.cantidadDeVertices() - 1;
                    }
                }
                estadosFinales.add(indiceDeVerticeActual);
            }
        }
        miGrafo.insertarVertice();
        for (int i = 0; i < miGrafo.cantidadDeVertices(); i++) {
            for (char letraEnTurno : miLenguaje.getAlfabeto()) {
                List<AdyacenteConPeso> listaDeAdyacenciaDelVerticeActual = miGrafo.listaDeAdyacencia.get(i);
                int verticeDestino = ObtenerVerticeDestinoDeLPeso(listaDeAdyacenciaDelVerticeActual, letraEnTurno);
                AdyacenteConPeso adyacenteConPesoDeLetraEnTurno = new AdyacenteConPeso(verticeDestino, letraEnTurno);
                if (!listaDeAdyacenciaDelVerticeActual.contains(adyacenteConPesoDeLetraEnTurno)) {
                    miGrafo.insertarArista(i, miGrafo.cantidadDeVertices() - 1, letraEnTurno);
                }
            }
        }
    }

    private int ObtenerVerticeDestinoDeLPeso(List<AdyacenteConPeso> listaDeAdy, char letra) {
        int indiceDeVerticeDestino = 0;
        for (AdyacenteConPeso adyacenteEnTurno : listaDeAdy) {
            if (adyacenteEnTurno.getPeso() == letra) {
                indiceDeVerticeDestino = adyacenteEnTurno.getIndiceDeVertice();
            }
        }
        return indiceDeVerticeDestino;
    }

    public boolean esPalabraAceptada(String palabra) throws PalabraInvalidad {
        miLenguaje.validarPalabra(palabra);
        int indiceDeVertice = estadoInicial;
        for (int i = 0; i < palabra.length(); i++) {
            char simboloActual = palabra.charAt(i);
            List<AdyacenteConPeso> listaDeAdyEnTurno = miGrafo.listaDeAdyacencia.get(indiceDeVertice);
            int verticeDestino = ObtenerVerticeDestinoDeLPeso(listaDeAdyEnTurno, simboloActual);
            indiceDeVertice = verticeDestino;
        }
        return estadosFinales.contains(indiceDeVertice);
    }
}
