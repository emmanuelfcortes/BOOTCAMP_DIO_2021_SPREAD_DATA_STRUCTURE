package br.com.stream;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {


    public static void main(String[] args) {

        List<String> myList = Arrays.asList("1", "0", "2", "7", "9", "12", "4", "8", "3");

        /**Vamos utilizar o stream para imprimir em tela todos os elementos da lista:
         * stream().foreach() vai percorrer toda a lista*/

        /***************** IMPLEMENTAÇÃO 1 *******************/
        System.out.println("\n\n ------------------> Imprimindo todos os elementos em tela, na forma que foram inseridos:\n");
        System.out.println("IMPLEMENTAÇÃO 1: UTILIZANDO STREM().FOREACH()");

        myList.stream().forEach(new Consumer<String>() {
            int index = 0;

            @Override
            public void accept(String s) {
                System.out.println("Elemento " + index + ": " + s);
                index++;
            }
        });

        /***************** IMPLEMENTAÇÃO 2 ****************************/
        System.out.println("\nImplementação 2: Utilizando Lambda function");
        myList.stream().forEach(s -> {
            int index = myList.indexOf(s);
            System.out.println("Element " + index + ": " + s);
        });
        /***************** IMPLEMENTAÇÃO 3 ****************************/
        System.out.println("\nImplementação 3: reduzindo o stream().forEach para forEach()");
        myList.forEach(s -> {
            int index = myList.indexOf(s);
            System.out.println("Element " + index + ": " + s);
        });

        /***************** IMPLEMENTAÇÃO 4 ****************************/
        System.out.println("\nImplementação 4: utilizando method reference");
        /** METHOD REFERENCE OBSERVATIONS: This kind of sintax means that the recept
         * element (that will be introduced at expression in parentesis) will run the method
         * in right side of the sentence. This method is part of Class declared in sentence
         * left side */
        myList.forEach(System.out::println);

        System.out.println("\n\n ------------------> Copiando os 5 primeiros elementos da lista para um Set:\n");

        /***************************************************************************************/
        /************   COLOCANDO OS 5 PRIMEIROS ELEMENTOS DE UMA LIST DENTRO DE UM SET *******/
        /***************************************************************************************/

        //OBSERVAÇÃO: SE HOUVE ALGUM ELEMENTO REPETIDO NA LISTA, O SET NÃO VAI REPETI-LO!!!!!
        /***************** IMPLEMENTAÇÃO 1 ****************************/
        System.out.println("\n Implementação 1: ");
        Set<String> mySet = new HashSet<>();
        mySet.addAll(myList.subList(0, 5));
        System.out.println(mySet);

        /***************** IMPLEMENTAÇÃO 2 ****************************/
        System.out.println("\n Implementação 2: ");
        Set<String> setFive = myList.stream().limit(5).collect(Collectors.toSet());
        System.out.println(setFive);

        /***************************************************************************************/
        /************   Transformando a Lista de strings em Lista de inteiros *******/
        /***************************************************************************************/

        System.out.println("\n\nTransformando a lista de Strings em uma lista de inteiros.");

        /***************** IMPLEMENTAÇÃO 1 - UTILIZANDO FUNCTIONS ****************************/
        System.out.println("Implementação 1, utilizando new functions: ");

        List<Integer> myListInt = myList.stream()
                .map(new Function<String, Integer>() {

                    @Override
                    public Integer apply(String s) {
                        return Integer.parseInt(s);
                    }
                }).collect(Collectors.toList());
        System.out.println(myListInt);

        /***************** IMPLEMENTAÇÃO 2 - UTILIZANDO LAMBDA FUNCTIONS ****************************/
        System.out.println("Implementação 2, utilizando lambda functions: ");

        List<Integer> myListInt2 = myList.stream()
                .map((s) -> Integer.parseInt(s)).collect(Collectors.toList());
        System.out.println(myListInt2);

        /***************** IMPLEMENTAÇÃO 3 - UTILIZANDO METHOD FUNCTION ****************************/
        System.out.println("Implementação 3, utilizando method function: ");
        List<Integer> myListInt3 = myList.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println(myListInt3);

        /***************** IMPLEMENTAÇÃO 4 - UTILIZANDO mapINT ****************************/
        System.out.println("Implementação 3, utilizando method function: ");
        IntStream myListInt4 = myList.stream().mapToInt(Integer::parseInt);
        myListInt4.forEach(System.out::println);

        /*****************************************************************************************/
        /************   Colocando os elementos pares e maiores que 2 em uma lista separada *******/
        /***************************************************************************************/

        /***************** IMPLEMENTAÇÃO 1 - UTILIZANDO A LISTA DE INTEIROS myListInt gerada anteriormente */
        System.out.println(" \n\n --------------> Colocando os elementos pares maiores que 2 em uma lista");
        System.out.println(" \n Implementação 1 - Utilizando um novo ArrayList ");
        List<Integer> listaPares = new ArrayList<>();
        myListInt.forEach(num -> {
            if ((num % 2) == 0 && num > 2)
                listaPares.add(num);
        });
        System.out.println("Lista de pares: " + listaPares);

        /***************** IMPLEMENTAÇÃO 2 - UTILIZANDO FILTER()*/
        System.out.println("\nImplementação 2 - utilizando stream().Filter()");
        List<Integer> listaPares2 = myListInt
                .stream()
                .filter(num -> num % 2 == 0 && num > 2)
                .collect(Collectors.toList());
        System.out.println(listaPares2);
        /*****************************************************************************************/
        /************   Achando a média dos valores em uma lista *******/
        /***************************************************************************************/

        /***************** IMPLEMENTAÇÃO 1 - UTILIZANDO A LISTA INICIAL DE STRINGS myList e o MAPTOINT*/

        System.out.println("\n\nCalculando a média de valores: " + myList);
        System.out.println("\nImplementação 1: utilizando a lista de inteiros myListInt gerada anteriormente");
        System.out.print("Média: ");
        myList.stream().mapToInt(Integer::parseInt).average().ifPresent(System.out::println);

        /*****************************************************************************************/
        /************   Removendo os números ímpares de uma lista *******/
        /***************************************************************************************/

        System.out.println("\n\nRemovendo os números negativos.");

        /***************************** IMPLEMENTAÇÃO 1 - Utilizando iterator ********************/
        System.out.println("\n Implementação 1");
        List<Integer> auxListInt = new ArrayList<>();
        auxListInt.addAll(myListInt);
        System.out.println("Lista inteira: " + auxListInt);
        Iterator<Integer> iterator = auxListInt.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() % 2 > 0)
                iterator.remove();
        }
        System.out.println("Lista alterada: " + auxListInt);

        /***************************** IMPLEMENTAÇÃO 2 - Utilizando Stream() e function new Predicate() ********************/
        System.out.println("\n Implementação 2");
        auxListInt.clear();
        auxListInt.addAll(myListInt);
        System.out.println("Lista original: " + auxListInt);
        auxListInt.removeIf(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if (integer % 2 > 0)
                    return true;
                return false;
            }
        });
        System.out.println("Lista alterada: " + auxListInt);

        /***************************** IMPLEMENTAÇÃO 3 - Utilizando lambda function ao invés de implementar a function
         * completa do new Predicate() ********************/
        System.out.println("\n Implementação 3");
        auxListInt.clear();
        auxListInt.addAll(myListInt);
        System.out.println("Lista original: " + auxListInt);
        auxListInt.removeIf((integer) -> integer % 2 != 0);
        System.out.println("Lista alterada: " + auxListInt);

        /*****************************************************************************************/
        /************   Encontrando o maior e o menor valor *******/
        /***************************************************************************************/
        System.out.println("\nEncontrando o maior e o menor valor");
        System.out.println("Implementação 1");
        System.out.print("Max: ");
        Integer max = myListInt.stream()
                .max((i1, i2) -> {
                    if (i1 > i2) return 1;
                    if (i1 < 12) return -1;
                    return 0;
                })
                .get();

        System.out.println(max);

//        myListInt.remove( 1);
        System.out.print("Menor: ");

        Integer min = myListInt.stream()
                .min((i1, i2) -> {
                    if (i1 > i2) return 1;
                    if (i1 < 12) return -1;
                    return 0;
                })
                .get();

        System.out.println(min);

    }
}
