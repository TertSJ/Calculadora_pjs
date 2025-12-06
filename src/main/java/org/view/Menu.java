package org.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Scanner;

import org.Controller.ControllerCalculadora;
import org.model.Operacao;
import org.reflections.Reflections;


public class Menu {


    public static void show(){
        Scanner s = new Scanner(System.in);

        Reflections reflection = new Reflections("org.model");
        int opcao;
        int primeiroNumero , segundoNumero, resultado ;

        Set<Class <? extends Operacao>> classesOperacoes = reflection.getSubTypesOf(Operacao.class);
        List<Class <? extends Operacao>> operacoesLista = new ArrayList<>(classesOperacoes);

        for (int i = 0; i < operacoesLista.size(); i++){
            System.out.println((i + 1) + " - " + operacoesLista.get(i).getSimpleName());

        }

        System.out.println("0 - Sair");
        System.out.println("Digite uma opção : ");
        opcao = Integer.parseInt(s.nextLine().trim());

        while (opcao != 0) {


            try {
                Class<? extends Operacao> claseAtual = operacoesLista.get(opcao - 1);
                Operacao operacao = claseAtual.getDeclaredConstructor().newInstance();

                System.out.println(claseAtual.getSimpleName() + " foi selecionada.");

                System.out.print("Digite o primeiro número da "+ claseAtual.getSimpleName() + " : ");
                primeiroNumero = Integer.parseInt(s.nextLine().trim());
                System.out.print("Digite o segundo número da " + claseAtual.getSimpleName() + " : " );
                segundoNumero = Integer.parseInt(s.nextLine().trim());


                ControllerCalculadora controlador = new ControllerCalculadora();
                resultado = controlador.executarOperacao(operacao, primeiroNumero, segundoNumero);

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
