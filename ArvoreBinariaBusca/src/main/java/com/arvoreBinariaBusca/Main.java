package com.arvoreBinariaBusca;

import com.arvoreBinariaBusca.model.Obj;

public class Main {
    public static void main(String[] args) {

        ArvoreBinariaBusca<Integer> arvore = new ArvoreBinariaBusca<Integer>();
        ArvoreBinariaBusca<Obj> arvoreUsandoObj = new ArvoreBinariaBusca<>();
        arvore.remove(-10);


        arvore.inserir(10);
        arvore.inserir(3);
        arvore.inserir(15);
        arvore.inserir(5);
        arvore.inserir(1);
        arvore.inserir(13);
        arvore.inserir(20);
        arvore.exibirInOrdem();


        System.out.println(arvore.encontrarNo(10));
        System.out.println(arvore.encontrarNo(3));
        System.out.println(arvore.encontrarNo(15));
        System.out.println(arvore.encontrarNo(1));
        System.out.println(arvore.encontrarNo(5));
        System.out.println(arvore.encontrarNo(13));
        System.out.println(arvore.encontrarNo(20));
        System.out.println("************************* IMPLEMENTAÇÃO PROFESSOR DO ENCONTRAR NO ******************************");
        System.out.println(arvore.encontrarNoImplementacaoProfessor(10));
        System.out.println(arvore.encontrarNoImplementacaoProfessor(3));
        System.out.println(arvore.encontrarNoImplementacaoProfessor(15));
        System.out.println(arvore.encontrarNoImplementacaoProfessor(1));
        System.out.println(arvore.encontrarNoImplementacaoProfessor(5));
        System.out.println(arvore.encontrarNoImplementacaoProfessor(13));
        System.out.println(arvore.encontrarNoImplementacaoProfessor(20));

        arvore.remove(10);

        System.out.println(arvore.encontrarNo(10));
        System.out.println(arvore.encontrarNo(3));
        System.out.println(arvore.encontrarNo(15));
        System.out.println(arvore.encontrarNo(1));
        System.out.println(arvore.encontrarNo(5));
        System.out.println(arvore.encontrarNo(13));
        System.out.println(arvore.encontrarNo(20));
        System.out.println("************************* IMPLEMENTAÇÃO PROFESSOR UTILIZANDO OBJETO ABSTRATO ******************************");

       arvoreUsandoObj.inserir(new Obj(10));
       arvoreUsandoObj.inserir(new Obj(3));
       arvoreUsandoObj.inserir(new Obj(15));
       arvoreUsandoObj.inserir(new Obj(1));
       arvoreUsandoObj.inserir(new Obj(5));
       arvoreUsandoObj.inserir(new Obj(13));
       arvoreUsandoObj.inserir(new Obj(20));
       arvoreUsandoObj.exibirInOrdem();




        /*

        arvore.remove(10);// posicao

        arvore.remove(3);// posicao 1
        arvore.remove(15);// posicao 2

        arvore.remove(1);// posicao 3

        arvore.remove(5);// posicao 4
        arvore.remove(13); // posicao 5
        arvore.remove(20); // posicao 6

        */

    }

}
