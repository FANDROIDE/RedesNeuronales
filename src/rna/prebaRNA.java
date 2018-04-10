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
public class prebaRNA {
    public static void main(String[] args) {
        int nodosK=4;
        int nodosJ=5;
        
        RedNeuronal RNA=new RedNeuronal(nodosK,nodosJ,6,8);
        double balance=-1;
        double capaI[][]={{1,1,1,0,1,1,1,balance},
                          {1,0,0,0,0,0,1,balance},
                          {1,1,0,1,1,1,0,balance},
                          {1,1,0,1,0,1,1,balance},
                          {1,0,1,1,0,0,1,balance},
                          {0,1,1,1,0,1,1,balance},
                          {0,1,1,1,1,1,1,balance},
                          {1,1,0,0,0,0,1,balance},
                          {1,1,1,1,1,1,1,balance},
                          {1,1,1,1,0,1,1,balance}
        };
        double aprender[][]={{0,0,0,0,0,0,0,0,1,1},
                             {0,0,0,0,1,1,1,1,0,0},
                             {0,0,1,1,0,0,1,1,0,0},
                             {0,1,0,1,0,1,0,1,0,1}};
        RNA.crearRed();
        RNA.inicializaPesos();
        int n=60000;
        int i=0;
        int epoca;
        double error;
        int k=0;
        boolean noigual=false;
        while(i<capaI.length && k<n){
            epoca=i;
            if(i==0)
                System.out.println("****Epoca"+epoca+" ****** Itercion"+k);
            for(int c=0;c<7;c++){
                System.out.print(""+Math.round(capaI[epoca][c])+",");
            }
            System.out.println("Aprender");
            for(int c=0;c<nodosK;c++){
                System.out.print(" "+Math.round(aprender[c][epoca])+",");
            }
            System.out.println(" Salida ");
            RNA.entradasJ(capaI[epoca]);
            RNA.activacionJ();
            RNA.entradasK();
            RNA.activacionK();
            RNA.errorCapaK(aprender, epoca);
            for(int c=0;c<nodosK;c++){
                System.out.print(" "+Math.round(RNA.getActivacionK(c))+",");
            }
            double decimal=0;
            int t=0;
            for(int c=nodosK-1;c>=0;c--){
                decimal+=RNA.getActivacionK(c)*Math.pow(2, t);
                t++;
            }
            System.out.println(" decimal "+decimal);
            noigual=false;
            for(int c=0;c<nodosK;c++){
                if(RNA.getActivacionK(c)==aprender[c][epoca]){
                
                }else{
                    noigual=true;
                }
            }
            if(noigual){
                i=-1;
                RNA.pesos_JK();
                RNA.errorCapaJ();
                RNA.pesos_IJ();
            }
            i++;
            k++;
        }
        RNA.verPesos_IJ();
        RNA.verPesos_JK();
    }
    
}
