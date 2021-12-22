package com.projeto_no;

public class Main {
    public static void main(String[] args) {
        No<String> no1 = new No<String>("conteudo_No1");
        No<String> no2 = new No<String>("conteudo_No2");
        No<Long> no3 = new No<>(333L);
        No<Integer> no4 = new No<>(444);
        no1.setProximoNo(no2);
        no2.setProximoNo(no3);
        no3.setProximoNo(no4);
        System.out.println(no1);
        System.out.println(no1.getProximoNo());//no2
        System.out.println(no1.getProximoNo().getProximoNo());//no3
        System.out.println(no1.getProximoNo().getProximoNo().getProximoNo());//no4
        System.out.println("************************************************");
        System.out.println(no2);
        System.out.println(no2.getProximoNo());
        System.out.println(no3);
        System.out.println(no3.getProximoNo());
        System.out.println(no4);
        System.out.println(no4.getProximoNo());
    }
}
