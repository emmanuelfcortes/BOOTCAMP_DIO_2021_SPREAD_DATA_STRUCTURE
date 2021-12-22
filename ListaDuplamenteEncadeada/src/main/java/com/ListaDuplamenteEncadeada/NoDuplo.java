package com.ListaDuplamenteEncadeada;

public class NoDuplo<T> {
    private T conteudo;
    private NoDuplo<T> proximoNo=null;
    private NoDuplo<T> anteriorNo = null;


    public NoDuplo(T conteudo) {
        this.conteudo = conteudo;
    }
    public NoDuplo(){

    }

    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public NoDuplo<T> getProximoNo() {
        return proximoNo;
    }

    public void setProximoNo(NoDuplo<T> proximoNo) {
        this.proximoNo = proximoNo;
    }

    public NoDuplo<T> getAnteriorNo() {
        return anteriorNo;
    }

    public void setAnteriorNo(NoDuplo<T> anteriorNo) {
        this.anteriorNo = anteriorNo;
    }

}
