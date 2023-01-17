package proyecto_Grafos;

import java.util.*;

public class GrafoPesado {

    public List<List<AdyacenteConPeso>> listaDeAdyacencia;

    public GrafoPesado() {
        listaDeAdyacencia = new ArrayList<>();
    }

    public int cantidadDeVertices() {
        return listaDeAdyacencia.size();
    }

    public void validarVertice(int posDeVertice) {
        if (posDeVertice < 0 || posDeVertice >= cantidadDeVertices()) {
            throw new ArrayIndexOutOfBoundsException("posicion invalida");
        }
    }

    public boolean existeAdyacencia(int posDeVerticeOrigen, int posicionDeVerticeDestino) {
        validarVertice(posDeVerticeOrigen);
        validarVertice(posicionDeVerticeDestino);
        List<AdyacenteConPeso> listaDeAdyacenciaDeOrigen = listaDeAdyacencia.get(posDeVerticeOrigen);
        for (AdyacenteConPeso adyacenteEnTurno : listaDeAdyacenciaDeOrigen) {
            if (adyacenteEnTurno.getIndiceDeVertice() == posicionDeVerticeDestino) {
                return true;
            }
        }
        return false;
    }

    public void insertarVertice() {
        List<AdyacenteConPeso> nuevaListaDeAdyacencia = new ArrayList<>();
        listaDeAdyacencia.add(nuevaListaDeAdyacencia);
    }

    public void insertarArista(int posDeVerticeOrigen, int posicionDeVerticeDestino, char peso) {
        if (!existeAdyacencia(posDeVerticeOrigen, posicionDeVerticeDestino)) {
            List<AdyacenteConPeso> listaDeAyacenciaDeOrigen = listaDeAdyacencia.get(posDeVerticeOrigen);
            AdyacenteConPeso nuevaAdyacencia = new AdyacenteConPeso(posicionDeVerticeDestino, peso);
            listaDeAyacenciaDeOrigen.add(nuevaAdyacencia);
        }
    }

    public int cantidadDeAristas() {
        int cantidad = 0;
        for (List<AdyacenteConPeso> listaDeAdyacenciaConPesoEnTurno : listaDeAdyacencia) {
            cantidad += listaDeAdyacenciaConPesoEnTurno.size();
        }
        return cantidad;
    }
}
