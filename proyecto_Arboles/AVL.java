package proyecto_Arboles;

public class AVL extends ArbolBinario {

    public void insertar(int codigoAInsertar, LIbro libroAInsertar) {
        if (codigoAInsertar < 1) {
            throw new IllegalArgumentException("Codigo a Insertar invalido");
        }
        if (libroAInsertar == null) {
            throw new ExceptionInInitializerError("libro a insertar no debe ser nulo");
        }
        super.raiz = this.insertar(raiz, codigoAInsertar, libroAInsertar);
    }

    private NodoBinario insertar(NodoBinario nodoActual, int codigoAInsertar, LIbro libroAInsertar) {
        if (NodoBinario.esNodoVacio(nodoActual)) {
            NodoBinario nuevoNodo = new NodoBinario();
            nuevoNodo.setCodigo(codigoAInsertar);
            nuevoNodo.setLibrito(libroAInsertar);
            return nuevoNodo;
        }
        if (codigoAInsertar < nodoActual.getCodigo()) {
            NodoBinario supuestoHijoIzquierdo = insertar(nodoActual.getHijoIzquierdo(), codigoAInsertar, libroAInsertar);
            nodoActual.setHijoIzquierdo(supuestoHijoIzquierdo);
            return this.balancear(nodoActual);
        }
        if (codigoAInsertar > nodoActual.getCodigo()) {
            NodoBinario supuestoHijoDerecho = insertar(nodoActual.getHijoDerecho(), codigoAInsertar, libroAInsertar);
            nodoActual.setHijoDerecho(supuestoHijoDerecho);
            return this.balancear(nodoActual);
        }
        nodoActual.setLibrito(libroAInsertar);
        return nodoActual;
    }

    public LIbro eliminar(int codigoAEliminar) {
        if (codigoAEliminar < 1) {
            throw new IllegalArgumentException("Codigo a eliminar invalido");
        }
        LIbro librito = super.buscar(codigoAEliminar);
        if (librito == null) {
            throw new ExceptionInInitializerError("No existe el codigo a eliminar");
        }
        super.raiz = eliminar(raiz, codigoAEliminar);
        return librito;
    }

    private NodoBinario eliminar(NodoBinario nodoActual, int codigoAEliminar) {
        if (nodoActual.getCodigo() > codigoAEliminar) {
            NodoBinario supuestohijoHizquierdo = eliminar(nodoActual.getHijoIzquierdo(), codigoAEliminar);
            nodoActual.setHijoIzquierdo(supuestohijoHizquierdo);
            return this.balancear(nodoActual);
        }
        if (nodoActual.getCodigo() < codigoAEliminar) {
            NodoBinario supuestoHijoDerecho = eliminar(nodoActual.getHijoDerecho(), codigoAEliminar);
            nodoActual.setHijoDerecho(supuestoHijoDerecho);
            return this.balancear(nodoActual);
        }
        if (nodoActual.esHoja()) {
            return NodoBinario.nodoVacio();
        }
        if (nodoActual.esNodoConSoloHijoIzquierdo()) {
            return nodoActual.getHijoIzquierdo();
        }
        if (nodoActual.esNodoConSoloHijoDerecho()) {
            return nodoActual.getHijoDerecho();
        }
        NodoBinario nodoSucesor = obtenerSucesor(nodoActual.getHijoDerecho());
        NodoBinario supuestoHijoDerecho = eliminar(nodoActual.getHijoDerecho(), nodoSucesor.getCodigo());
        nodoActual.setLibrito(nodoSucesor.getLibrito());
        nodoActual.setCodigo(nodoSucesor.getCodigo());
        nodoActual.setHijoDerecho(supuestoHijoDerecho);
        return this.balancear(nodoActual);
    }

    private NodoBinario obtenerSucesor(NodoBinario nodoActual) {
        return obtenerSucesor(nodoActual, null);
    }

    private NodoBinario obtenerSucesor(NodoBinario nodoActual, NodoBinario nodoAnterior) {
        if (NodoBinario.esNodoVacio(nodoActual)) {
            return nodoAnterior;
        }
        return obtenerSucesor(nodoActual.getHijoIzquierdo(), nodoActual);
    }

    private NodoBinario balancear(NodoBinario nodoActual) {
        int alturaPorIzquierda = super.altura(nodoActual.getHijoIzquierdo());
        int alturaPorDerecha = super.altura(nodoActual.getHijoDerecho());
        int diferencia = alturaPorIzquierda - alturaPorDerecha;
        if (diferencia > 1) {
            NodoBinario hijoIzquierdo = nodoActual.getHijoIzquierdo();
            int alturaRamaIzquierda = altura(hijoIzquierdo.getHijoIzquierdo());
            int alturaRamaDerecha = altura(hijoIzquierdo.getHijoDerecho());
            if (alturaRamaDerecha > alturaRamaIzquierda) {
                return rotacionDobleADerecha(nodoActual);
            }
            return rotacionSimpleADerecha(nodoActual);
        } else if (diferencia < -1) {
            NodoBinario hijoDerecho = nodoActual.getHijoDerecho();
            int alturaRamaIzquierda = altura(hijoDerecho.getHijoIzquierdo());
            int alturaRamaDerecha = altura(hijoDerecho.getHijoDerecho());
            if (alturaRamaIzquierda > alturaRamaDerecha) {
                return rotacionDobleAIzquierda(nodoActual);
            }
            return rotacionSimpleAIzquierda(nodoActual);
        }
        return nodoActual;
    }

    private NodoBinario rotacionSimpleADerecha(NodoBinario nodoActual) {
        NodoBinario nodoQueRota = nodoActual.getHijoIzquierdo();
        nodoActual.setHijoIzquierdo(nodoQueRota.getHijoDerecho());
        nodoQueRota.setHijoDerecho(nodoActual);
        return nodoQueRota;
    }

    private NodoBinario rotacionSimpleAIzquierda(NodoBinario nodoActual) {
        NodoBinario nodoQueRota = nodoActual.getHijoDerecho();
        nodoActual.setHijoDerecho(nodoQueRota.getHijoIzquierdo());
        nodoQueRota.setHijoIzquierdo(nodoActual);
        return nodoQueRota;
    }

    private NodoBinario rotacionDobleADerecha(NodoBinario nodoActual) {
        NodoBinario rotacionSimpleAIzq = rotacionSimpleAIzquierda(nodoActual.getHijoIzquierdo());
        nodoActual.setHijoIzquierdo(rotacionSimpleAIzq);
        return rotacionSimpleADerecha(nodoActual);
    }

    private NodoBinario rotacionDobleAIzquierda(NodoBinario nodoActual) {
        NodoBinario rotacionSimpleADer = rotacionSimpleADerecha(nodoActual.getHijoDerecho());
        nodoActual.setHijoDerecho(rotacionSimpleADer);
        return rotacionSimpleAIzquierda(nodoActual);
    }
}
