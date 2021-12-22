package com.projetoGenerics;

import java.util.ArrayList;
import java.util.List;

/*Genercis são estrutura que permitem uma maior flexibilização para a passagem de parâmetros.
* São usados para:
 * Evitar casting (mudança de tipo) excessivo;
 * Evitar código repetitivo;
 * Encontrar erros em tempo de compilação.
 *
 * CONVENSÕES
 * Map<K,V> -> K=Key e V=Value
 * List<E> -> E=Element;
 * List<T> -> T= Type;
 * List<?> -> quando pode ser qualquer tipo genérico
*
*
*
*
* */
public class Main {
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<Integer>();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        List<String> l2 = new ArrayList<String>();
        l2.add("Papai");
        l2.add("Papudo");
        l2.add("Mandrião");
        Listas<Integer> lista = new Listas<Integer>();
        Listas<String> listaStr = new Listas<String>();
        lista.lista.add(50);
        lista.lista.add(51);
        lista.lista.add(52);
        lista.lista.add(53);
        Listas<Integer> l3 = new Listas<Integer>(l1);
        System.out.println("******** L1 *************");
        lista.imprimeLista(l1);
        System.out.println("******** L2 *************");
        listaStr.imprimeLista(l2);
        System.out.println("******** L3 *************");
        lista.imprimeLista(l3.lista);
        System.out.println("******** LISTA *************");
        lista.imprimirMe();
    }
}
