package br.com.listasImplementacao1;

import java.util.*;

public class MainGato {
    public static void main(String[] args) {
        /***
         * Implementando uma lista de gatos;

         */
        Gato gato1 = new Gato("Felix", 10, "amarelo");
        Gato gato2 = new Gato("Tom", 2, "cinza");
        Gato gato3 = new Gato("Gatuno", 5, "branco");
        Gato gato4 = new Gato("Frajola", 7, "preto");

//        A lista pode ser povoada desta forma

//*********     List<Gato> gatos = new ArrayList<>(Arrays.asList(gato1, gato2, gato3, gato4));

//        Ou desta outra maneira:

        List<Gato> gatos = new ArrayList<>() {{
            add(gato1);
            add(gato2);
            add(gato3);
            add(gato4);
        }};

        System.out.println("Imprimindo a lista de gatos na ordem de inserção");
        System.out.println(gatos);
        System.out.println("Colocando a lista de gatos em ordem aleatória: ");
        Collections.shuffle(gatos);
        System.out.println(gatos);
        System.out.println("Colocando a lista em ordem natural (ordenado por nome em ordem alfabética");
        /**
         * Para ordenar por nome em ordem alfabética, utilizando Collections.sort( List <T>)
         * é preciso implementar  interface Comparable<T> na classe Gato,
         * com o método compareTo;
         * */
        Collections.sort(gatos);
        System.out.println(gatos);

        /**
         * Para ordenar a Lista de gatos, por idade, utilizando Collections.sort(List <T>, Comparator) ou
         * gatos.sort(Comparator ) é necessário implementarmos a interface Comparator dentro de uma classe.
         * Vamos criar uma classe chamada ComparatorGato e fazer a implementação.
         * */
        System.out.println("Colocando a lista em ordem, por idade: ");
        ComparatorIdade comparatorIdade = new ComparatorIdade();

        //Pode ordenar com o método sort em Collections, conforme abaixo

        // Collections.sort( gatos, comparatorIdade );

        // Ou pode-se usar o método sort direto da Lista, conforme abaixo:
        gatos.sort(comparatorIdade);
        System.out.println(gatos);

        System.out.println("Colocando a lista em ordem, por cor: ");

        /** Para esta funcionalidade foi implementado um Comprator específico */
        ComparatorCor comparatorCor = new ComparatorCor();
        gatos.sort(comparatorCor);
        System.out.println(gatos);

        System.out.println("Adicionando elemento:");
        gatos.add(new Gato("Felix", 3, "azul"));
        System.out.println(gatos);
        System.out.println("Adicionando elemento:");
        System.out.println(gatos);
        gatos.add(new Gato("Felix", 2, "azul"));
        System.out.println("Colocando a lista em ordem pelos parâmetros nome, cor e idade");
        /** Foi implementado um Comparator específico para essa funcionalidade */
        ComparatorNomeCorIdade comparatorNomeCorIdade = new ComparatorNomeCorIdade();
        gatos.sort(comparatorNomeCorIdade);
        System.out.println(gatos);

    }
}

class ComparatorIdade implements Comparator<Gato> {

    @Override
    public int compare(Gato o1, Gato o2) {
        /**
         * Esse método retorna os seguintes valores:
         * -> 0 , caso as idades sejam iguais;
         * -> 1 , caso a idade da esquerda seja MAIOR que a da direita;
         * -> -1 , caso a idade da esquerda seja MENOR que a da direita;
         * */
//        Pode ser implementado na mão, conforme abaixo;

//        int i=0;
//        if( o1.getIdade() > o2.getIdade() )
//            i=1;
//        if( o1.getIdade() > o2.getIdade() )
//            i=-1;
//        return i;

//        Ou, pode ser utilizado o método compare() de Integer
        return Integer.compare(o1.getIdade(), o2.getIdade());

    }
}

class ComparatorCor implements Comparator<Gato> {

    @Override
    public int compare(Gato o1, Gato o2) {
        /**
         * Esse método retorna os seguintes valores:
         * -> 0 , caso as cores sejam iguais;
         * -> 1 , caso a cor da esquerda seja MAIOR que a da direita;
         * -> -1 , caso a cor da esquerda seja MENOR que a da direita;
         * */

        return o1.getCor().compareToIgnoreCase(o2.getCor());

    }
}

class ComparatorNomeCorIdade implements Comparator<Gato> {

    @Override
    public int compare(Gato o1, Gato o2) {
        int resultadoComparacaoNome = o1.getNome().compareToIgnoreCase(o2.getNome());
        if (resultadoComparacaoNome != 0)
            return resultadoComparacaoNome;

        int resultadoComparacaoCor = o1.getCor().compareToIgnoreCase(o2.getCor());
        if (resultadoComparacaoCor != 0)
            return resultadoComparacaoCor;

        return Integer.compare(o1.getIdade(), o2.getIdade());

    }
}