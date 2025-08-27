package org.view;

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
        s.nextLine();
        Reflections reflection = new Reflections("org.model");
        int opcao;


        Set<Class <? extends Operacao>> classeOperacoes = reflection.getSubTypesOf(Operacao.class);
        List<Class <? extends Operacao>> operacoesLista = new ArrayList<>(classeOperacoes);


        for (int i = 0; i < operacoesLista.size(); i++){
            System.out.println((i + 1) + " - " + operacoesLista.get(i).getSimpleName());
        }


    }
}
