package com.arvoreBinariaBusca;

public class NoArvore<T extends Comparable <T>>{
    private T conteudo;
    private NoArvore<T> noEsq;
    private NoArvore<T> noDir;

    public NoArvore(T conteudo) {
        this.conteudo = conteudo;
        this.noEsq = this.noDir = null;
    }

    public NoArvore() {
    }

    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public NoArvore<T> getNoEsq() {
        return noEsq;
    }

    public void setNoEsq(NoArvore<T> noEsq) {
        this.noEsq = noEsq;
    }

    public NoArvore<T> getNoDir() {
        return noDir;
    }

    public void setNoDir(NoArvore<T> noDir) {
        this.noDir = noDir;
    }

    @Override
    public String toString() {
        return "NoArvore{" +
                "conteudo=" + conteudo +
                '}';
    }
}
