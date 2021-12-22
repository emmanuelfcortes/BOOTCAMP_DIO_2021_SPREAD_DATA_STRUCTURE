package com.listaencadeada;

public class Main {
    public static void main(String[] args) {
        ListaEncadeada<Integer> lista = new ListaEncadeada();
        lista.add(0);
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        System.out.println("\n*********INSERÇÃO INICIAL 5 elementos*********");
        System.out.println(lista);
        System.out.println("\nTamanho: "+lista.length());
        //System.out.println("\n"+ lista.indexes());
        System.out.println("\n*******ADICIONANDO 50 AO ELEMENTO NO2******");
        lista.add(50,2);
        System.out.println(lista);
        System.out.println("\nTamanho: "+lista.length());
        //System.out.println("\n"+ lista.indexes());
        System.out.println("\n*************PEGANDO O conteudo do no5 (POSIÇÃO 6)");
        System.out.println("No5: "+lista.getNo(5));
        System.out.println("********PEGANDO O PRIMEIRO ELEMENTO DA FILA E EXCLUINDO-O");
        System.out.println(lista);
        System.out.println("get: "+lista.get());
        System.out.println(lista);
        System.out.println("\n***************Removendo o No1:50***********");
        lista.remove(1);
        System.out.println(lista);
        System.out.println("Pegando o conteudo No3:"+lista.getNo(3));
        System.out.println("\n********ESVAZIANDO A PILHA");
        System.out.println(lista.get());
        System.out.println("\n"+ lista.indexes());
        System.out.println(lista.get());
        System.out.println(lista.get());
        System.out.println("\n"+ lista.indexes());
        System.out.println(lista.get());
        System.out.println("Size:"+lista.length());
        System.out.println("\n"+ lista.indexes());
        System.out.println("Vazia? " +lista.isEmpty());
        System.out.println("Get no vazio 1: "+lista.get());//lista já vazia
        System.out.println("Size:"+lista.length());
        System.out.println("\n"+ lista.indexes());
        System.out.println("Get no vazio 2: "+lista.get());//lista já vazia
        System.out.println("Size:"+lista.length());
        System.out.println("\n"+ lista.indexes());
        System.out.println("Size:"+lista.length());
        lista.remove(5);
        System.out.println("Size:"+lista.length());

        lista.add(100,10);
        System.out.println("\n"+ lista.indexes());
        System.out.println("Repovoando Size: "+lista.length());
        lista.add(50,12);
        System.out.println("\n"+ lista.indexes());
        System.out.println("Repovoando Size2: "+lista.length());
        lista.add(200,0);
        System.out.println("Repovoando Size3: "+lista.length());
        lista.add(150,1);
        System.out.println("Repovoando Size4: "+lista.length());
        lista.add(30,8);
        System.out.println("Repovoando Size4: "+lista.length());
        System.out.println(lista);
        lista.remove(3);
        System.out.println(lista);
        System.out.println("Size: "+lista.length());
        System.out.println("Vazia? " +lista.isEmpty());
    }
}
