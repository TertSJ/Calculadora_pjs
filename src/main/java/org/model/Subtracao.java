package org.model;

public class Subtracao implements Operacao{

    public int calc(int a, int b){

        return a - b;
    }

    @Override
    public String sinal() {
        return " - ";
    }
}
