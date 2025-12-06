package org.Controller;

import org.model.CalculadoraCore;
import org.model.Operacao;

public class ControllerCalculadora {
    public int executarOperacao(Operacao operacao, int operando1 , int operando2){
        CalculadoraCore calculadora = new CalculadoraCore();
        return calculadora.executarOperacao(operacao, operando1, operando2);
    }
}
