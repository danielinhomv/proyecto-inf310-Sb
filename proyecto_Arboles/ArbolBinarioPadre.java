package proyecto_Arboles;

import javax.swing.JTable;

public interface ArbolBinarioPadre {

    LIbro buscar(int codigo);

    boolean existe(int codigoAInsertar);

    void recorridoEnPostOrden(JTable tabla);

    int size();

    int altura();
}
