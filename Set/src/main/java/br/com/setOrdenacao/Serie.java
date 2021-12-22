package br.com.setOrdenacao;

import java.util.Objects;

public class Serie implements Comparable<Serie> {
    private String nome;
    private String genero;
    private Integer tempoEpisodio;

    public Serie() {
    }

    public Serie(String nome, String genero, Integer tempoEpisodio) {
        this.nome = nome;
        this.genero = genero;
        this.tempoEpisodio = tempoEpisodio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getTempoEpisodio() {
        return tempoEpisodio;
    }

    public void setTempoEpisodio(Integer tempoEpisodio) {
        this.tempoEpisodio = tempoEpisodio;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", tempoEpisodio=" + tempoEpisodio +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Serie)) return false;
        Serie serie = (Serie) o;
        return getNome().equals(serie.getNome()) &&
                getGenero().equals(serie.getGenero()) &&
                getTempoEpisodio().equals(serie.getTempoEpisodio());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getGenero(), getTempoEpisodio());
    }

    @Override
    public int compareTo(Serie o) {
        int comparacaoTempo = Integer.compare(this.tempoEpisodio,o.getTempoEpisodio());
        if(comparacaoTempo!=0)
            return comparacaoTempo;
        /* Se houver duas séries com tempo de episódios iguais, uma delas não será armazenada, devido
        * as restrições de elementos repetidos da estrutura Set. Portanto, outros parâmetros de comparação
        * devem ser estabelecidos;
        * */
        int comparacaoGenero = this.genero.compareTo(o.getGenero());
        if(comparacaoGenero!=0)
            return comparacaoGenero;

        return this.nome.compareTo(o.getNome());
    }
}
