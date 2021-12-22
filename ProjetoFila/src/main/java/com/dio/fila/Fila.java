package com.dio.fila;

public class Fila<T> {

    No primeiroDaFila = null;
    No ultimoDaFila = null;

    public void enqueue(T object){
        No<T> novoNo = new No<T>(object);
        if(isEmpty()) {

            primeiroDaFila = novoNo;
            ultimoDaFila = novoNo;
        }
        else if(primeiroDaFila==ultimoDaFila){
            ultimoDaFila = novoNo;
            primeiroDaFila.setRefNo(ultimoDaFila);
        }
        else {
            ultimoDaFila.setRefNo(novoNo);
            ultimoDaFila = novoNo;
        }
    }

    public T dequeue(){
        No<T> noParaRetorno = primeiroDaFila;
        if(isEmpty())
            return null;
        else if(primeiroDaFila==ultimoDaFila){
            primeiroDaFila=null;
            ultimoDaFila=null;
        }
        else
            primeiroDaFila =  primeiroDaFila.getRefNo();
        return (T) noParaRetorno;
    }
    public No<T> first(){
        return primeiroDaFila;
    }

    public boolean isEmpty(){
        return primeiroDaFila == null;
    }
    @Override
    public String toString(){
        String stringParaRetorno= "Fila: {";
        if(isEmpty()){
            stringParaRetorno+=" }";
            return stringParaRetorno;
        }

        else{
            No noIteracao = primeiroDaFila;
            do{
                stringParaRetorno+=noIteracao.getObject()+",";
                noIteracao=noIteracao.getRefNo();
            }while(noIteracao!=null);
            return stringParaRetorno + "}";
        }
    }
}
