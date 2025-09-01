package org.model;

public class Divisao implements Operacao{
    @Override
    public int calc(int a, int b) {
        if (b== 0){
            throw new ArithmeticException("Divisão por zero.");
        }
        return a/b;
    }

    @Override
    public String sinal() {
        return " / ";
    }
}
