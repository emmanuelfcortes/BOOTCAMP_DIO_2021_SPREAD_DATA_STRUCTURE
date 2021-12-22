package br.com.listasImplementacao1;

public class Gato implements Comparable<Gato> {
    private String nome;
    private int idade;
    private String cor;

    public Gato() {
    }

    public Gato(String nome, int idade, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "Gato{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cor='" + cor + '\'' +
                '}';
    }

    @Override
    public int compareTo(Gato o) {
        /**
         * O método compareTo deve retornar os seguintes valores:
         * -> 0, se os objetos comparados forem iguais;
         * -> 1, se o objeto à esquerda da comparação for MAIOR que o objeto da direita
         * -> -1, se o objeto à esquerda da compração for MENOR que o objeto da dirieta;
         * */

        return this.getNome().compareToIgnoreCase(o.getNome());

    }
}
