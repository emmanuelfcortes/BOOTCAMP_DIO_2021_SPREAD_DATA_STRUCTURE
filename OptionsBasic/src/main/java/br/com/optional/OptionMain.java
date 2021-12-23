package br.com.optional;

import java.util.*;
import java.util.function.Predicate;

public class OptionMain {
    public static void main(String[] args) {
        Optional<String> optional;
        List<Optional<String>> optinalList = new ArrayList<>();
        System.out.println("\n ******************** TRABALHANDO COM OPTIONAL ****************");
        /*** O optional ajuda na tratativa de recebimento de "nulls", evitando o NullPointerException.
         * Para isso, basta utilizar o preenchimento do optional com Optional.ofNullable() e para
         * inicializar, utilizar o Optional.empty()
         * Caso precise que gere um NullPointerException ao preencher o Optional com valores nulos,
         * deve-se povoá-lo utilizando o Optional.of().
         * */
        optional = Optional.of("optional1");
        System.out.println("Mostrando conteúdo do optional : ");
        System.out.println(optional);
        optinalList.add(Optional.of("primeiro da lista"));
        optinalList.add(Optional.of("segundo da lista"));
        optinalList.add(Optional.ofNullable(null));
        optinalList.add(Optional.ofNullable("quarto"));
        System.out.println("Imprimindo a lista de optional");
        System.out.println(optinalList);

        for (int i = 0; i < optinalList.size(); i++) {
            if (!optinalList.get(i).isPresent())
                System.out.println("Encontrou um vaziozinho no index " + i);
        }

        /** Usando Optional.ifPresent(Consumer) para imprimir um elemento, caso ele não seja nulo.*/
        System.out.println("Imprimindo os não nulos: ");
        for (Optional<String> opt : optinalList) {
            opt.ifPresent(System.out::println);
        }

        System.out.println("\nRemovendo os vazios da lista: ");
        System.out.print("Lista original: ");
        System.out.println(optinalList);
        System.out.print("Lista resultante: ");
        Iterator<Optional<String>> iteratorOpt = optinalList.iterator();

        optinalList.removeIf((opt) -> !opt.isPresent());
        /*
        while (iteratorOpt.hasNext()) {
            if (!iteratorOpt.next().isPresent())
                iteratorOpt.remove();
        }
        */
//        optinalList.removeIf((op) -> !op.isPresent());
        System.out.println(optinalList);

        optinalList.add(Optional.ofNullable(null));
        optinalList.add(Optional.of("Sexto elemento"));
        optinalList.add(Optional.ofNullable(null));

        System.out.println("\n Percorrendo a lista e dizendo se os elementos estão presentes ou não (são vazios)");
        int count = -1;
        for (Optional<String> opt: optinalList) {
            count++;
            int finalCount = count;
            opt.ifPresentOrElse(
                    (op) -> System.out.println("Elemento: " + finalCount + " presente"),
                    () -> System.out.println(" Elemento " + finalCount + " VAZIO")
            );
        }


        System.out.println("\nSe Optional.of recebe um valor null, ele retorna uma exception, " +
                "o que vai ocorrer agora.");
        optional = Optional.of(null);
    }
}
