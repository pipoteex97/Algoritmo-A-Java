package Modelo;

import java.awt.*;
import java.util.*;

public class Nodo {
    
    private String nombreNodo;
    //Este atributo es la heuristica: en este caso se utiliza la distancia linea recta como la misma.
    private int dlr, costoAcumulado, funcionHeuristica, nivel;
    //Flag e integer utilizado para colocarlo con un color diferente 
    //dentro del arbol de búsqueda si se encuentra cerrado.
    private boolean cerrado, inicio, fin;
    private int tiempo, variacionParaPruebas;
    private ArrayList<Aristas> aristas = new ArrayList<>();
    private Nodo padre;
    
    public Nodo(String nombreNodo, int dlr, boolean inicio, boolean fin){
        setNombreNodo(nombreNodo);
        setDlr(dlr);
        setInicio(inicio);
        setFin(fin);
        setFuncionHeuristica(0);
        setCostoAcumulado(0);
        setNivel(0);
        setTiempo(100);
    }

    public int getVariacionParaPruebas() {
        return variacionParaPruebas;
    }

    public void setVariacionParaPruebas(int variacionParaPruebas) {
        this.variacionParaPruebas = variacionParaPruebas;
    }
    
    
    
    public boolean isInicio() {
        return inicio;
    }

    public void setInicio(boolean inicio) {
        this.inicio = inicio;
    }

    public boolean isFin() {
        return fin;
    }

    public void setFin(boolean fin) {
        this.fin = fin;
    }
    
    
    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public boolean isCerrado() {
        return cerrado;
    }

    public void setCerrado(boolean cerrado) {
        this.cerrado = cerrado;
    }
    
    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Nodo getPadre() {
        return padre;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }
    
    public int getCostoAcumulado() {
        return costoAcumulado;
    }

    public void setCostoAcumulado(int costoAcumulado) {
        this.costoAcumulado = costoAcumulado;
    }

    public int getDlr() {
        return dlr;
    }

    public void setDlr(int dlr) {
        this.dlr = dlr;
    }

    public String getNombreNodo() {
        return nombreNodo;
    }

    public void setNombreNodo(String nombreNodo) {
        this.nombreNodo = nombreNodo;
    }

    public ArrayList<Aristas> getAristas() {
        return aristas;
    }

    public void setAristas(ArrayList<Aristas> aristas) {
        this.aristas = aristas;
    }

    public int getFuncionHeuristica() {
        return funcionHeuristica;
    }

    public void setFuncionHeuristica(int funcionHeuristica) {
        this.funcionHeuristica = funcionHeuristica;
    }
    
    
}
