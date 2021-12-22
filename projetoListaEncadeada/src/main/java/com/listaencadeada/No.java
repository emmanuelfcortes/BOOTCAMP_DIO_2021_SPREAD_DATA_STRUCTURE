package com.listaencadeada;

public class No<T> {
    private T conteudo;
    private No<T> proximoNo=null;
    private int index;

    public No(){

    }
    public No(T conteudo){
        this.conteudo = conteudo;
    }
    public T getConteudo(){
        return this.conteudo;
    }
    public void setConteudo(T conteudo){
        this.conteudo=conteudo;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index){
        this.index=index;
    }

    public No<T> getProximoNo(){
        return this.proximoNo;
    }

    public void setProximoNo(No<T> proximoNo) {
        this.proximoNo = proximoNo;
    }
}
