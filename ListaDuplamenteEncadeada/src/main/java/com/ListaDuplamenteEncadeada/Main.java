package com.ListaDuplamenteEncadeada;

public class Main {
    public static void main(String[] args) {
        ListaDupla<String> listaDupla = new ListaDupla<String>();
        listaDupla.add("zero");
        listaDupla.add("um");
        listaDupla.add("dois");
        listaDupla.add("três");
        System.out.println(listaDupla);
        listaDupla.remove(0);
        System.out.println(listaDupla);
        listaDupla.remove(2);
        System.out.println(listaDupla);
        listaDupla.remove(1);
        System.out.println(listaDupla);
        listaDupla.remove(0);
        System.out.println(listaDupla);
        System.out.println("Tentando chamar a função get() com a lista vazia.");
        listaDupla.get();

        listaDupla.add("zerimo1",0);
        System.out.println(listaDupla);
        listaDupla.add("zerimo0",0);
        System.out.println(listaDupla);
        listaDupla.remove(0);
        System.out.println(listaDupla);
        listaDupla.add("zerimo2");
        System.out.println(listaDupla);
        listaDupla.add("zerimo3");
        System.out.println(listaDupla);
        System.out.println("Retornando e retirando o primeiro elemento: "+listaDupla.get());
        System.out.println(listaDupla);
        listaDupla.add("zerimo2.5",1);
        System.out.println(listaDupla);
        System.out.println("Retornando o primeiro elemento sem excluí-lo: "+listaDupla.getNo(0));
        System.out.println(listaDupla);
        System.out.println("Retornando o último elemento sem excluí-lo: "+listaDupla.getNo(2));
        System.out.println(listaDupla);
        // TESTAR ERRO DE CHAMADA AO getNo() com indice incorreto
        //System.out.println("Retornando um elemento com indice incorreto: "+listaDupla.getNo(3));
        //System.out.println(listaDupla);

        listaDupla.remove(-1);

    }
}
