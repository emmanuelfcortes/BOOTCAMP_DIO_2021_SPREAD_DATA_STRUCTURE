package com.projetoGenerics;

import java.util.ArrayList;
import java.util.List;

public class Listas<T> {
    public List<T> lista = new ArrayList<T>();
    public Listas(){

    }
    public Listas(List<T> lista){
        this.lista=lista;
    }
    public void imprimeLista(List<T> lista){
        for(T l: lista)
        System.out.println(l);
    }
    public void imprimirMe(){
        for(T l: this.lista)
            System.out.println(l);
    }

}
