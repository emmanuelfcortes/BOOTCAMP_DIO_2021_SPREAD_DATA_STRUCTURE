package br.com.map;

import java.util.*;

import static javax.swing.UIManager.put;

public class MainLivro {
    public static void main(String[] args) {
        final Livro livro1 = new Livro("Meu pé de laranja lima", 243);
        final Livro livro2 = new Livro("Diário de um banana", 111);
        final Livro livro3 = new Livro("O mundo de Sofia", 417);
        final Livro livro4 = new Livro("Operação Cavalo de Tróia", 417);

        final String autor1 = "Kierkgard";
        final String autor2 = "Monteiro Lobato";
        final String autor3 = "Tony Gaspar";
        final String autor4 = "J.J. Benites";

        Map<String, Livro> livros = new HashMap<String, Livro>() {{
            put(autor1, livro3);
            put(autor2, livro1);
            put(autor3, livro2);
            put(autor4, livro4);

        }};

        for (Map.Entry<String, Livro> livro : livros.entrySet()) {
            System.out.println("Livro: " + livro.getKey() + " - " + livro.getValue());
        }

        System.out.println("\nImprimindo na ordem de inserção: ");
        Map<String, Livro> livros2 = new LinkedHashMap<String, Livro>() {{
            put(autor1, livro3);
            put(autor2, livro1);
            put(autor3, livro2);
            put(autor4, livro4);

        }};
        System.out.println(livros2);
        System.out.println("\n Imprimindo em ordem alfabética de autor");
        Map<String, Livro> livros3 = new TreeMap<String, Livro>() {{
            put(autor1, livro3);
            put(autor2, livro1);
            put(autor3, livro2);
            put(autor4, livro4);

        }};
        System.out.println(livros3);

        System.out.println("\n Ordenando por nome dos livros");

        Set<Map.Entry <String, Livro>> livros4 = new TreeSet<Map.Entry<String, Livro>>( new OrdenacaoPorNomeDoLivro());
        livros4.addAll(livros3.entrySet());



        System.out.println(livros4.size());
        for (Map.Entry<String, Livro> livroEntry : livros4) {
            System.out.println(livroEntry.getKey()+" - " + livroEntry.getValue().getNome() + " - " + livroEntry.getValue().getPaginas());
        }

    }
}

// IMPLEMENTANDO UM COMPARATOR!
class OrdenacaoPorNomeDoLivro implements Comparator<Map.Entry<String, Livro>> {


    @Override
    public int compare(Map.Entry<String, Livro> m1, Map.Entry<String, Livro> m2) {
        return m1.getValue().getNome().compareToIgnoreCase(m2.getValue().getNome());
    }
}
