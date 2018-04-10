package rna;

/**
 * Created by feliciano on 31/03/18.
 */

public class Neurona {
    float entradas[];
    float salida;
    String tipoNeurona;
    float u;//umbral
    float w[];//sinapsis//peso
    float L;//Aprendizaje
    Sigmoide sigmoide=new Sigmoide();
    public Neurona(int e,String tipoNeurona){
        entradas=new float[e];
        this.tipoNeurona=tipoNeurona;
        w=new float[e];
        u=0.5f;
        L=0.2f;
    }


    public float[] getEntradas() {
        return entradas;
    }

    public void setEntradas(float[] entradas) {
        this.entradas = entradas;
    }
    public float salida(){
        float s = 0.0f;
        if(tipoNeurona.equals("e")){
            s= entradas[0];
        }
        else{
            s=u;
            for(int i=0;i<entradas.length;i++){
                s=s+(entradas[i]*w[i]);
            }
        }
        return s;
    }
    public String tipoNeurona(){
        return tipoNeurona;
    }
    public int nEntradas(){
        return entradas.length;
    }
    public float calcularError(float salidaActual,float salidaCorrecta){
        float error=(salidaCorrecta-salidaActual)*salidaActual*(1-salidaActual);
        return error;
    }
    public void calcularPeso(int i,float error){
        w[i]=w[i]+L*error*entradas[i];
    }
    public void activacion(){
        double suma=0;
        for(int i=0;i<entradas.length;i++){
            suma+=entradas[i]*w[i];
        }
        double activacionu=sigmoide.funcion(suma);
    }
}
