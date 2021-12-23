package br.com.queueBasic;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class QueueMain {
    public static void main(String[] args) {
        System.out.println("Implementando métodos da Queue(Fila) FIFO (first in, first out): ");
        Queue<String> fila = new LinkedList<String>(){{
            add("June");
            add("Lion");
            add("Pepeu");
            add("Babel");
            add("Laratiel");
            add("Lion");
        }};
        System.out.println(fila);

        /* Removendo o primeiro elemento Lion que encontrar */
        System.out.println("\nRemovendo o primeiro elemento \"Lion\" que encontrar.");
        fila.remove("Lion");
        System.out.println(fila);

        System.out.println("\nRetornando o primeiro elemento da fila sem excluí-lo: "+fila.peek());
        System.out.println(fila);

        System.out.println("\nRetornando o primeiro elemento da fila sem excluí-lo com element: "+fila.element());
        System.out.println("\n Com element, caso a fila esteja vazia, vai retornar um Exception.");
        System.out.println(fila);

        System.out.println("\nRetornando o primeiro elemento da fila e excluindo-o: "+fila.poll());
        System.out.println(fila);

        for(String str: fila){
            if(str.compareTo("Lion")==0)
                System.out.println("Removeu ?"+fila.remove(str));
            System.out.println(fila);
        }



    }
}
