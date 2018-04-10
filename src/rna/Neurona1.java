/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rna;

/**
 *
 * @author feliciano
 */
public class Neurona1 {
    double activacionu;
    double[] entradas;
    double[] pesos;
    double errorNodo;
    static Sigmoide sigmoide;
    
    public Neurona1(int nentradas){
        pesos=new double[nentradas];
        entradas=new double[nentradas];
        sigmoide=new Sigmoide();
        errorNodo=0;
    }
    public void activacion(){
        double suma=0;
        for(int i=0;i<entradas.length;i++){
            suma+=entradas[i]*pesos[i];
        }
        activacionu=sigmoide.funcion(suma);
    }

    public double getActivacionu() {
        return activacionu;
    }

    public void setActivacionu(double activacionu) {
        this.activacionu = activacionu;
    }

    public double[] getEntradas() {
        return entradas;
    }

    public void setEntradas(double[] entradas) {
        this.entradas = entradas;
    }

    public double[] getPesos() {
        return pesos;
    }

    public void setPesos(double[] pesos) {
        this.pesos = pesos;
    }

    public double getErrorNodo() {
        return errorNodo;
    }

    public void setErrorNodo(double errorNodo) {
        this.errorNodo = errorNodo;
    }
    public void verPesos(){
        for(int i=0;i<pesos.length;i++){
            System.out.println(pesos[i]+"    -  ");
        }
    }
    
}
