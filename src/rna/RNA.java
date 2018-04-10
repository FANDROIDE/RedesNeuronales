package rna;

/**
 * Created by feliciano on 31/03/18.
 */

public class RNA {
    int nEntradas, nSalidas;

    int[] capasOcultas;
    Neurona capaOculta[][];
    Neurona entrada[],salida[];
    //Neurona cerebro[][];
    int k;//entrada+NcapasOculpas+salida
    public int getnEntradas(){return nEntradas;
    }

    public void setnEntradas(int nEntradas) {
        this.nEntradas = nEntradas;
    }

    public int getnSalidas() {
        return nSalidas;
    }

    public void setnSalidas(int nSalidas) {
        this.nSalidas = nSalidas;
    }

    public int[] getCapasOcultas() {
        return capasOcultas;
    }

    public void setCapasOcultas(int[] capasOcultas) {
        this.capasOcultas = capasOcultas;
    }

    public Neurona[][] getCapaOculta() {
        return capaOculta;
    }

    public void setCapaOculta(Neurona[][] capaOculta) {
        this.capaOculta = capaOculta;
    }

    public Neurona[] getEntrada() {
        return entrada;
    }

    public void setEntrada(Neurona[] entrada) {
        this.entrada = entrada;
    }

    public Neurona[] getSalida() {
        return salida;
    }

    public void setSalida(Neurona[] salida) {
        this.salida = salida;
    }

    public int getK() {
        return k;
    }

    //float w[][][];//sinapsis{k,i,j}
    public void setK(int k) {
        this.k = k;
    }

    //float u;//umbral
    public RNA(int nEntradas, int[] capasOcultas, int nSalidas) {
        //3,[4,4],2
        this.nEntradas=nEntradas;
        this.nSalidas=nSalidas;
        this.capasOcultas=capasOcultas;
        this.k=1+capasOcultas.length+1;
        /////se crean las neuronas
        this.entrada=new Neurona[nEntradas];
        this.salida=new Neurona[nSalidas];
        System.out.println("se crean las neuronas de la capa de entrada");
        for(int i=0;i<nEntradas;i++){
            entrada[i]=new Neurona(1,"e");
        }
        capaOculta=new Neurona[capasOcultas.length][capasOcultas[0]];
        System.out.println("se recorre el numero de capas ocultas: " + capasOcultas.length);
        for(int co=0;co<capasOcultas.length;co++){//se recorre el numero de capas ocultas
            System.out.println("se recorre el numero de neuronas para cada capa: " + capasOcultas[co]);
            for(int nn=0;nn<capasOcultas[co];nn++){//se recorre el numero de neuronas para cada capa
                if(co==0){
                    System.out.println("se crean las neuronas de la capa oculta 0");
                    capaOculta[co][nn]=new Neurona(nEntradas,"o");//la primera capa oculta tendra el numero de enradas igual a las entradas de la red
//                    if(capasOcultas.length==1){
//                        capaOculta[co][nn]=new Neurona(capasOcultas[co],"o");
//                    }
                }
                if(co==capasOcultas.length-1){
                    System.out.println("se crean las neuronas de la capa de salida");
                    for(int k=0;k<nSalidas;k++){
                        salida[k]=new Neurona(capasOcultas[co],"s");
                    }  
                }
                if(co>0){
                        System.out.println("se crean las neuronas de la capa oculta: "+co);
                        capaOculta[co][nn]=new Neurona(capasOcultas[co-1],"o");
                    }
            }

        }
        //se termina de crear las neuronas
    }

}
