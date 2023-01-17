package proyecto_Arboles;

import javax.swing.ImageIcon;

public class LIbro {

    private final String titulo;
    private final String editorial;
    private final String autor;
    private ImageIcon imagen;

    public LIbro(String titulo, String editorial, String autor) {
        this.titulo = titulo;
        this.editorial = editorial;
        this.autor = autor;
    }

    public ImageIcon getImagen() {
        return imagen;
    }

    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getAutor() {
        return autor;
    }

}
