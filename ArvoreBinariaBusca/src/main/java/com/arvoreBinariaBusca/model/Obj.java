package com.arvoreBinariaBusca.model;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Obj extends ObjetoArvore <Obj> {
    Integer conteudo;

    public Obj(){};
    public Obj(Integer conteudo){
        this.conteudo = conteudo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Obj)) return false;
        Obj obj = (Obj) o;
        return conteudo.equals(obj.conteudo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(conteudo);
    }


    public String toString() {
        return conteudo.toString();
    }

    public int compareTo(@NotNull Obj outro) {
        int i = 0;
        if(this.conteudo < outro.conteudo)
            i = -1;
        else if(this.conteudo > outro.conteudo)
            i = 1;

        return i;
    }
}
