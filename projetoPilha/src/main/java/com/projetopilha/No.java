package com.projetopilha;

public class No {
    private int dado;
    private No reference;

    public No(){}

    public No(int dado) {
        this.dado = dado;
    }

    public int getDado() {
        return dado;
    }

    public void setDado(int dado) {
        this.dado = dado;
    }

    public No getReference() {
        return reference;
    }

    public void setReference(No reference) {
        this.reference = reference;
    }

    @Override
    public String toString() {
        return "No{" +
                "dado=" + dado +
                '}';
    }
}
