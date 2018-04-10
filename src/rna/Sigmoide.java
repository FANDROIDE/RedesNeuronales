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
public class Sigmoide {
    double e,p;
    public Sigmoide(){
        e=Math.E;
        p=1;
    }
    public double funcion(double a){
        return (1/(1+Math.pow(e, -a/p)));
    }
}
