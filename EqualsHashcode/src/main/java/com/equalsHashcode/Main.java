package com.equalsHashcode;

public class Main {
    public static void main(String[] args) {
        Carro car1 = new Carro("fiat");
        Carro car2 = new Carro("fiat");
        boolean b = car1.equals(car2);
        System.out.println("Equals ="+b);

        System.out.println("Hash code car1");
        car1.hashCode();
        System.out.println("Hash code car2");
        car2.hashCode();
    }
}
