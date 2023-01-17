package proyecto_Arboles;

public class NodoBinario {

    private int codigo;    //clave
    private LIbro librito;  //valor
    private NodoBinario hijoIzquierdo;
    private NodoBinario hijoDerecho;

    public void setLibrito(LIbro librito) {
        this.librito = librito;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public NodoBinario getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(NodoBinario hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public NodoBinario getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(NodoBinario hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }
    public static NodoBinario nodoVacio(){
        return null;
    }
    public static boolean esNodoVacio(NodoBinario nodo) {
        return nodo ==NodoBinario.nodoVacio();
    }

    public boolean esHijoIzquierdoVacio() {
        return esNodoVacio(this.hijoIzquierdo);
    }

    public boolean esHijoDerechoVacio() {
        return esNodoVacio(this.hijoDerecho);
    }

    public boolean esNodoCompleto() {
        return !esHijoIzquierdoVacio() && !esHijoDerechoVacio();
    }

    public boolean esNodoConSoloHijoIzquierdo() {
        return !esHijoIzquierdoVacio() && esHijoDerechoVacio();
    }

    public boolean esNodoConSoloHijoDerecho() {
        return esHijoIzquierdoVacio() && !esHijoDerechoVacio();
    }

    public boolean esHoja() {
        return esHijoIzquierdoVacio() && esHijoDerechoVacio();
    }

    public LIbro getLibrito() {
        return librito;
    }

}
