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
        int opcao = 0;
        int a = 0 , b = 0 ;

        Class<? extends Operacao> atualOp;

        Set<Class <? extends Operacao>> classeOperacoes = reflection.getSubTypesOf(Operacao.class);
        List<Class <? extends Operacao>> operacoesLista = new ArrayList<>(classeOperacoes);


        for (int i = 0; i < operacoesLista.size(); i++){
            System.out.println((i + 1) + " - " + operacoesLista.get(i).getSimpleName());
        }
        System.out.println("0 - Sair");
        System.out.println("Digite uma opção :");
        opcao = s.nextInt();

        if (opcao<= operacoesLista.size()){
            System.out.print("Digite o primeiro número : ");
            a = s.nextInt();
            System.out.print("Digite o segundo número : ");
            b = s.nextInt();

            atualOp = operacoesLista.get(opcao);
            Object instancia = atualOp.getDeclaredConstructor().newInstance();

            // Procura o método "executar"
            Method metodo = atualOp.getMethod("calc");

            System.out.println(metodo.invoke(instancia));
        }





    }
}
