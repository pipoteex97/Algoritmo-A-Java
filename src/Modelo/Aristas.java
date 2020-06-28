package Modelo;

public class Aristas {
    
    private String idArista;
    private int costoArista;
    private Nodo nodoA, nodoB;
    
    public Aristas(String nombreArista, int costoArista, Nodo nodoA, Nodo nodoB){
        setNombreArista(nombreArista);
        setCostoArista(costoArista);
        setNodoA(nodoA);
        setNodoB(nodoB);
    }

    public String getNombreArista() {
        return idArista;
    }

    public void setNombreArista(String nombreArista) {
        this.idArista = nombreArista;
    }

    public int getCostoArista() {
        return costoArista;
    }

    public void setCostoArista(int costoArista) {
        this.costoArista = costoArista;
    }

    public Nodo getNodoA() {
        return nodoA;
    }

    public void setNodoA(Nodo nodoA) {
        this.nodoA = nodoA;
    }

    public Nodo getNodoB() {
        return nodoB;
    }

    public void setNodoB(Nodo nodoB) {
        this.nodoB = nodoB;
    }
    
    
}
