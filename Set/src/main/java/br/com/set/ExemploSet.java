package br.com.set;

import java.sql.SQLOutput;
import java.util.*;

public class ExemploSet {
    public static void main(String[] args) {

        /**
         * Diferenças nas implementaçõa da interface SET:
         * Características do Set:
         *  -> Não guarda índice;
         *  -> Não necessariamente mantem a ordenação de entrada.
         *  -> Não aceita elementos repetidos;
         * HashSet - contém todas as características acima;
         * LinkedHashSet - contém as características acima, exceto que ela mantém a ordem de inserção dos elementos;
         * Treeset - não permite elementos repetidos, mantém a ordem de inserção e ordena os elementos, assim que eles
         * são isneridos;
         * */

        /*Inicializando o SET*/


        Set<Double> set = new HashSet<Double>(Arrays.asList(1.0, 2.0, 3d, 4.5, 6d, 0d));
        System.out.println(set);// a saída não será na ordem de inserção, porque o HashSet não armazena em ordem;
        System.out.println("O elemento 4.5 está no conjunto (set): " + set.contains(4.5));
        System.out.println("Tamanho do conjunto (set): " + set.size());
        System.out.println("O menor valor do intervalo é: " + Collections.min(set));
        System.out.println("O maior valor do intervalo é: " + Collections.max(set));
        System.out.println("Utilizando o ITERATOR para somar os valores (set): ");
        Iterator<Double> iterator = set.iterator();
        Double soma = 0d;
        while (iterator.hasNext()) {
            Double next = iterator.next();
            soma += next;
        }
        System.out.println(set);
        System.out.println("Soma: "+ soma);
        System.out.println("Média dos valores: " + set.size());
        System.out.println("Removendo a nota O: ");
        set.remove(0d);
        System.out.println(set);
        System.out.println("Removendo todas as notas abaixo de 5: ");
        for(iterator = set.iterator();iterator.hasNext();){
            Double next = iterator.next();
            if(next < 5)
                iterator.remove();
        }
        System.out.println(set);
        System.out.println("Imprimindo elementos na ordem em que foram inseridos (deve-se utilizar LinkedHashSet): ");
        Set<Double> linkedSet = new LinkedHashSet<Double>(Arrays.asList(1.0, 2d, 3d, 4d, 5d, 6d));
        System.out.println(linkedSet);
        System.out.println("Tentando inserir um elemento repetido (2): (não será inserido) ");
        System.out.println("Conseguiu inserir: " + linkedSet.add(2d));
        System.out.println(linkedSet);
        System.out.println("Exibir as notas na ordem crescente");
        System.out.println("(É possível transferir para uma TreeSet e imprimir os elementos de forma ordenada)");
        TreeSet<Double> treeSet = new TreeSet<Double>();
//        Pode-se declarar dessa forma:
//        set = linkedSet;

        for( iterator=linkedSet.iterator(); iterator.hasNext(); set.add( iterator.next() ) ){}
        System.out.println("Ordem original: "+ set);

        for( iterator=linkedSet.iterator(); iterator.hasNext(); treeSet.add( iterator.next() ) ){}
        System.out.println("Ordenado: " + treeSet);
        System.out.println("Apagando todo o conjunto");
        treeSet.clear();
        System.out.println(treeSet);
        System.out.println("Está vazio ? "+ treeSet.isEmpty());


    }
}
