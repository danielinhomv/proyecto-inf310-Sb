package proyecto_Grafos;

public class AdyacenteConPeso implements Comparable<AdyacenteConPeso>{

    private int indiceDeVertice;
    private char peso;

    public AdyacenteConPeso(int indiceDeVertice) {
        indiceDeVertice = this.indiceDeVertice;
    }
    
    public AdyacenteConPeso(char peso) {
        this.peso = peso;
    }

    public AdyacenteConPeso(int indiceDeVertice, char peso) {
        this.indiceDeVertice = indiceDeVertice;
        this.peso = peso;
    }

    public int getIndiceDeVertice() {
        return indiceDeVertice;
    }

    public void setIndiceDeVertice(int indiceDeVertice) {
        this.indiceDeVertice = indiceDeVertice;
    }

    public char getPeso() {
        return peso;
    }

    public void setPeso(char peso) {
        this.peso = peso;
    }
  @Override
    public int compareTo(AdyacenteConPeso o) {
     Integer esteVertice=this.indiceDeVertice;
        Integer otroVertice=this.indiceDeVertice;
        return esteVertice.compareTo(otroVertice);
    }
    @Override
    public boolean equals(Object otro){
        if(otro==null){
            return false;
        }
        if(getClass()!=otro.getClass()){
            return false;
        }
        AdyacenteConPeso other=(AdyacenteConPeso)otro;
        return this.indiceDeVertice==other.indiceDeVertice;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.indiceDeVertice;
        return hash;
    }
    

}
