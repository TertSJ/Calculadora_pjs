package org.model;

public class Potencia implements Operacao{
    @Override
    public int calc(int a, int b) {
        int resultado = 1;

        for (int qMulti = 0; qMulti <= b; qMulti++ ){
            resultado = resultado * a;

        }
        if(b>=0){
        return resultado;
        }else{
        return 1/resultado;

        }

    }

    @Override
    public String sinal() {
        return " ^ ";
    }
}
