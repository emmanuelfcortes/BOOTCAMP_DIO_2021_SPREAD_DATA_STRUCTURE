package com.dio.fila;

public class Main {
    public static void main(String[] args) {
        String novo1 = "Conteudo No 1";
        int novo2 = 3;
        double novo3 = 50D;
        long novo4 = 30L;
        boolean novo5 = true;
        Fila fila = new Fila();// aceita qualquer tipo de dado na fila
        Fila<String> fila2 = new Fila();// aceita apenas o tipo String

        System.out.println("Fila vazia: "+fila.isEmpty());
        System.out.println(fila);
        System.out.println("***********Iniciando o povoamento da fila:");
        fila.enqueue(novo1);
        System.out.println("Inserindo no 1");
        System.out.println(fila);
        fila.enqueue(novo2);
        System.out.println("Inserindo no 2");
        System.out.println(fila);
        fila.enqueue(novo3);
        System.out.println("Inserindo no 3");
        System.out.println(fila);
        fila.enqueue(novo4);
        System.out.println("Inserindo no 4");
        System.out.println(fila);
        fila.enqueue(novo5);
        System.out.println("Inserindo no 5");
        System.out.println(fila);
        System.out.println("Primeiro da fila: "+fila.first());
        System.out.println("Fila vazia: "+fila.isEmpty());
        System.out.println("****************************************");
        System.out.println("***********Iniciando a retirada da fila:");
        System.out.println("Retirando no 1: " + fila.dequeue());
        System.out.println(fila);
        System.out.println("Primeiro da fila: "+fila.first());
        System.out.println("Retirando no 2: " + fila.dequeue());
        System.out.println(fila);
        System.out.println("Primeiro da fila: "+fila.first());
        System.out.println("Retirando no 3: " + fila.dequeue());
        System.out.println(fila);
        System.out.println("Primeiro da fila: "+fila.first());
        System.out.println("Retirando no 4: " + fila.dequeue());
        System.out.println(fila);
        System.out.println("Primeiro da fila: "+fila.first());
        System.out.println("Retirando no 5: " + fila.dequeue());
        System.out.println(fila);
        System.out.println("Primeiro da fila: "+fila.first());
        System.out.println("Retirando da fila vazia: " + fila.dequeue());
        System.out.println(fila);
        System.out.println("************** FILA 2 (APENAS STRING)************************");
        fila2.enqueue("papanamericano");
        fila2.enqueue("STRING2");
        fila2.enqueue("false COMO STRING");
        System.out.println(fila2);
    }
}
