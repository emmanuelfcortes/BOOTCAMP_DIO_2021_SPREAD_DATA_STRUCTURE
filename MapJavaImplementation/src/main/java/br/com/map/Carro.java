package br.com.map;

import java.util.Objects;

public class Carro implements Comparable<Carro> {
    private String modelo;
    private Double consumo;


    public Carro() {
    }

    public Carro(String modelo, Double consumo) {
        this.modelo = modelo;
        this.consumo = consumo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getConsumo() {
        return consumo;
    }

    public void setConsumo(Double consumo) {
        this.consumo = consumo;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "modelo='" + modelo + '\'' +
                ", consumo=" + consumo +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Carro)) return false;
        Carro carro = (Carro) o;
        return Objects.equals(getModelo(), carro.getModelo()) &&
                Objects.equals(getConsumo(), carro.getConsumo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getModelo(), getConsumo());
    }

    @Override
    public int compareTo(Carro c) {
        int result = this.getModelo().compareTo(c.getModelo());
        if( result != 0 ) {
            return result;
        }
        /*
        Não precisa implementar o código abaixo, que faz a avaliação do consumo,
        pois não vão haver chaves iguais, por se tratar de um Map.

         */
        if( this.getConsumo() < c.getConsumo() )
            return -1;

        if( this.getConsumo() > c.getConsumo() )
            return 1;

        return 0;
    }
}
