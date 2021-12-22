package br.com.listasInicial;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        //FORMAS DE INICIALIZAÇÃO DE UMA LISTA
        List lista = new ArrayList(); //Até o Java 5;
        List<Double> lista2 = new ArrayList<Double>(); //Até o Java 5;
        List<Double> lista3 = new ArrayList<>(); //A partir do Java 7;
//  ************************  implementações que deixam a lista imutável**********************
        List<Double> lista4 = List.of(1.0, 2.0, 3.0);// A partir do Java 9; Nesta implementação a List fica imutável.
        // lista4.add(4d); vai gerar um erro de UnsupportedOperationException
        List<Double> lista5 = Arrays.asList(1.0,2.0,3.0,4.0);
//        lista5.add(6.0); vai gerar um erro de UnsupportedOperationException
        List<Double> lista7 = List.of(1.0, 2.0, 3d,4d);
//        lista7.remove(0); vai gerar um erro de UnsupportedOperationException

//  ***********************  Inicialização da Lista com valores, deixando a lista ainda mutável **********************
        List<Double> lista6 = new ArrayList<Double>(Arrays.asList(1.0, 2.0, 3.0, 4.5, 5.0));
        System.out.println("Inicializando uma lista: ");
        System.out.println(lista6);
//        Executando várias operações na lIsta
        System.out.println("Adicionando elemento ao final da lista: ");
        lista6.add(6d);
        System.out.println(lista6);
        System.out.println("Adicionando elemento em uma posição específica");
        lista6.add(2, 3.5);
        System.out.println(lista6);
        System.out.println("Removendo um elemento específico, passando um index: ");
        lista6.remove(0);
        System.out.println(lista6);
        System.out.println("Removendo um elemento específico, passando o conteudo: ");
        lista6.remove(3.5);
        System.out.println(lista6);
        System.out.println("Retornando o index do elemento" + lista6.indexOf(1.0));
        System.out.println(lista6);
        System.out.println("Substituindo um elemento já existente da lista (index 1): " + lista6.set(1, 1.5) + " por 1.5");
        System.out.println(lista6);
        System.out.println("Verificando se existe o elemento 5.0: "+ lista6.contains(5.0));
        System.out.println(lista6);
        System.out.println("Exibindo um elemento em um index específico (index 2): "+ lista6.get(2));
//******************************************   VALORES MENORES E MAIORES ***********************************************
        System.out.println("Exibindo o menor elemento: "+ Collections.min(lista6));
        System.out.println("Exibindo o maior elemento: "+ Collections.max(lista6));
//******************************************   Utilizando ITERATOR para percorrer a lista ************
        System.out.print( "Somando os valores da lista utilizando ITERATOR: ");
        Iterator<Double> iterator = lista6.iterator();
          Double soma = 0d;
        while( iterator.hasNext() ) {

            soma += iterator.next();
        }
        System.out.println(soma);

        System.out.println(lista6);
        System.out.println("Removendo o elemento de indice 3");
        lista6.remove(3);
        System.out.println(lista6);
        System.out.println("Removendo os elementos com conteúdo abaixo de 4, utilizando ITERATOR");

        Iterator<Double> iterator2 = lista6.iterator();
        iterator = lista6.iterator(); // É NECESSÁRIO REINICIAR O ITERATOR!!!
        while(iterator.hasNext()){
//      Essa implementação gera um erro !!!!!!
            if((iterator.next())<4){
//            Double next = iterator.next();
//            if(next < 4){
                iterator.remove();
            }
        }
        System.out.println("Resultado: "+ lista6);
        System.out.println("Apgando toda a lista: ");
        lista6.clear();
        System.out.println(lista6);
        System.out.println("Verificando se a lista está vazia: "+ lista6.isEmpty());


    }

}
