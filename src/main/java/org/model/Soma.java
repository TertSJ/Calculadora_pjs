package org.model;

public class Soma implements Operacao{
    public int calc(int a , int b){
        return a+b;

    }

    @Override
    public String sinal() {
        return " + ";
    }
}
