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
public class RedNeuronal {
    int nodosCapaK;
    int entCapaK;
    int nodosCapaJ;
    int entCapaJ;
    double L=0.5;
    double [] entradas;
    Neurona1[] neuronK,neuronJ;
    static double balance=-1;

    public RedNeuronal(int nodosCapaK, int nodosCapaJ, int entCapaK, int entCapaJ) {
        this.nodosCapaK = nodosCapaK;
        this.entCapaK = entCapaK;
        this.nodosCapaJ = nodosCapaJ;
        this.entCapaJ = entCapaJ;
    }

public void crearRed(){
    neuronK=new Neurona1[nodosCapaK];
    for(int k=0;k<neuronK.length;k++){
        neuronK[k]=new Neurona1(entCapaK);
    }
    
    neuronJ=new Neurona1[nodosCapaJ];
    for(int j=0;j<neuronJ.length;j++){
        neuronJ[j]=new Neurona1(entCapaJ);
    }
}    
    
public void inicializaPesos(){
    for(int k=0;k<nodosCapaK;k++){
        for(int i=0;i<entCapaK;i++){
            neuronK[k].pesos[i]=Math.random();
        }
    }
    
    for(int j=0;j<nodosCapaJ;j++){
        for(int i=0;i<entCapaJ;i++){
            neuronJ[j].pesos[i]=Math.random();
        }
    }
    
}
public void entradasJ(double capaI[]){
    for(int j=0;j<nodosCapaJ;j++){
        for(int i=0;i<capaI.length;i++){
            neuronJ[j].entradas[i]=capaI[i];
        }
    }
}
public void activacionJ(){
    for(int i=0;i<nodosCapaJ;i++){
        neuronJ[i].activacion();
    }
}
public void activacionK(){
    for(int i=0;i<nodosCapaK;i++){
        neuronK[i].activacion();
    }
}
public void entradasK(){
    int j;
    for(int k=0;k<nodosCapaK;k++){
        for(j=0;j<nodosCapaJ;j++){
            neuronK[k].entradas[j]=neuronJ[j].getActivacionu();
        }
        neuronK[k].entradas[j]=balance;
    }
}
public void errorCapaK(double aprender[][],int epoca){
    double errorl=0;
    for(int k=0;k<nodosCapaK;k++){
        errorl=(aprender[k][epoca]-neuronK[k].getActivacionu())*neuronK[k].getActivacionu()*(1-neuronK[k].getActivacionu());
        neuronK[k].setErrorNodo(errorl);
    }
}
public void pesos_JK(){
    for(int k=0;k<nodosCapaK;k++){
        for(int i=0;i<entCapaK;i++){
            neuronK[k].pesos[i]+=(L*neuronK[k].getErrorNodo()*neuronK[k].entradas[i]);
        }
    }
}
public void errorCapaJ(){
    double suma,errj;
    for(int j=0;j<nodosCapaJ;j++){
        suma=0;
        for(int k=0;k<nodosCapaK;k++){
            suma+=(neuronK[k].getErrorNodo()*neuronK[k].pesos[j]);
        }
        errj=(neuronJ[j].getActivacionu()*(1-neuronJ[j].getActivacionu())*suma);
        neuronJ[j].setErrorNodo(errj);
    }
}
public void pesos_IJ(){
    for(int j=0;j<nodosCapaJ;j++){
        for(int i=0;i<entCapaJ;i++){
            neuronJ[j].pesos[i]+=L*neuronJ[j].getErrorNodo()*neuronJ[j].entradas[i];
        }
    }
}
public double getErrorK(){
    double suma=0;
    for(int j=0;j<nodosCapaK;j++){
        suma+=neuronK[j].getErrorNodo();
    }
    return (Math.abs(suma));
}
public double getActivacionK(int neuron){
    if(neuronK[neuron].getActivacionu()>=0.5){
        return(1);
    }
    else{
        return(0);
    }
}
public void verPesos_IJ(){
    System.out.println("********Actualia pesos IJ********");
    for(int j=0;j<nodosCapaJ;j++){
        neuronJ[j].verPesos();
    }
}
public void verPesos_JK(){
    System.out.println("********Actualia pesos JK********");
    for(int k=0;k<nodosCapaK;k++){
        neuronK[k].verPesos();
    }
}
}
