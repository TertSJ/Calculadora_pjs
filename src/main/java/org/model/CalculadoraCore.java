package org.model;

public class CalculadoraCore {
    public int executarOperacao(Operacao operacao, int operando1, int operando2){
        return operacao.calc(operando1,operando2);
    }
}
