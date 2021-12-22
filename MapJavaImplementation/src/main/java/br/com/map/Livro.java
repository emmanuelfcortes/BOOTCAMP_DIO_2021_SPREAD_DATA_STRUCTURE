package br.com.map;

import java.util.Objects;

public class Livro {
    private String nome;
    private int paginas;

    public Livro() {
    }

    public Livro(String nome, int paginas ) {
        this.paginas = paginas;
        this.nome = nome;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Livro)) return false;
        Livro livro = (Livro) o;
        return getPaginas() == livro.getPaginas() &&
                getNome().equals(livro.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPaginas(), getNome());
    }

    @Override
    public String toString() {
        return "Livro{" +
                "paginas=" + paginas +
                ", nome='" + nome + '\'' +
                '}';
    }
}
