package org.view;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Scanner;

import javassist.tools.reflect.Reflection;
import org.model.Operacao;
import org.reflections.Reflections;


public class Menu {


    public static void show(){
        Scanner s = new Scanner(System.in);

        Reflections reflection = new Reflections("org.model");
        int opcao;
        int primeiroNumero = 0 , segundoNumero = 0, resultado =0 ;

        Class<? extends Operacao> atualOp;

        Set<Class <? extends Operacao>> classeOperacoes = reflection.getSubTypesOf(Operacao.class);
        List<Class <? extends Operacao>> operacoesLista = new ArrayList<>(classeOperacoes);


        for (int i = 0; i < operacoesLista.size(); i++){
            System.out.println((i + 1) + " - " + operacoesLista.get(i).getSimpleName());
        }
        System.out.println("0 - Sair");
        System.out.println("Digite uma opção : ");
        opcao = s.nextInt();

        while (opcao != 0) {


            try {
                Class<? extends Operacao> claseAtual = operacoesLista.get(opcao - 1);
                Operacao operacao = claseAtual.getDeclaredConstructor().newInstance();

                System.out.println(claseAtual.getSimpleName() + " foi selecionada.");

                System.out.print("Digite o primeiro número da "+ claseAtual.getSimpleName() + " : ");
                primeiroNumero = s.nextInt();
                System.out.print("Digite o segundo número da " + claseAtual.getSimpleName() + " : " );
                segundoNumero = s.nextInt();




                resultado = operacao.calc(primeiroNumero, segundoNumero);

                System.out.println("O resultado da " + claseAtual.getSimpleName() + " de " + primeiroNumero + operacao.sinal() + segundoNumero + " foi = " + resultado);
            }catch (Exception e){
                System.out.println("Operação invalida!");
            }

            for (int i = 0; i < operacoesLista.size(); i++){
                System.out.println((i + 1) + " - " + operacoesLista.get(i).getSimpleName());
            }
            System.out.println("0 - Sair");
            System.out.println("Digite uma opção :");


            opcao = s.nextInt();
        }

    }
}
