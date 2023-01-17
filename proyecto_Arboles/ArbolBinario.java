package proyecto_Arboles;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

public class ArbolBinario implements ArbolBinarioPadre {

    NodoBinario raiz;

    public ArbolBinario() {
    }

    @Override
    public LIbro buscar(int codigoAbuscar) {
        if (codigoAbuscar < 1) {
            throw new IllegalArgumentException("codigo a buscar invalida");
        } else {
            return buscar(raiz, codigoAbuscar);
        }
    }

    public LIbro buscar(NodoBinario nodoAcual, int codigoABuscar) {
        if (NodoBinario.esNodoVacio(nodoAcual)) {
            return null;
        }
        if (nodoAcual.getCodigo() > codigoABuscar) {
            return buscar(nodoAcual.getHijoIzquierdo(), codigoABuscar);
        }
        if (nodoAcual.getCodigo() < codigoABuscar) {
            return buscar(nodoAcual.getHijoDerecho(), codigoABuscar);
        }
        return nodoAcual.getLibrito();

    }

    @Override
    public boolean existe(int codigo) {
        return buscar(codigo) != null;
    }

    @Override
    public void recorridoEnPostOrden(JTable tabla) {
        List<LIbro> recorridoLibro = new ArrayList<>();
        List<Integer> recorridoCodigo = new ArrayList<>();
        recorridoEnPostOrden(raiz, recorridoCodigo, recorridoLibro);
        for (int i = 0; i < recorridoCodigo.size(); i++) {
            tabla.setValueAt(recorridoCodigo.get(i), i, 0);
            tabla.setValueAt(recorridoLibro.get(i).getTitulo(), i, 1);
            tabla.setValueAt(recorridoLibro.get(i).getEditorial(), i, 2);
            tabla.setValueAt(recorridoLibro.get(i).getAutor(), i, 3);

        }
    }

    private void recorridoEnPostOrden(NodoBinario nodoActual, List<Integer> recorridoCodigo, List<LIbro> recorridoLibro) {
        if (!NodoBinario.esNodoVacio(nodoActual)) {
            recorridoEnPostOrden(nodoActual.getHijoIzquierdo(), recorridoCodigo, recorridoLibro);
            recorridoEnPostOrden(nodoActual.getHijoDerecho(), recorridoCodigo, recorridoLibro);
            recorridoCodigo.add(nodoActual.getCodigo());
            recorridoLibro.add(nodoActual.getLibrito());

        }
    }

    @Override
    public int size() {
        return size(raiz);
    }

    private int size(NodoBinario nodoActual) {
        if (NodoBinario.esNodoVacio(nodoActual)) {
            return 0;
        }
        return size(nodoActual.getHijoIzquierdo()) + size(nodoActual.getHijoDerecho()) + 1;
    }

    @Override
    public int altura() {
        return altura(raiz);
    }

    protected int altura(NodoBinario nodoActual) {
        if (NodoBinario.esNodoVacio(nodoActual)) {
            return 0;
        }
        if (altura(nodoActual.getHijoIzquierdo()) > altura(nodoActual.getHijoDerecho())) {
            return altura(nodoActual.getHijoIzquierdo()) + 1;
        }
        return altura(nodoActual.getHijoDerecho()) + 1;
    }

}
