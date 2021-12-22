package br.com.setOrdenacao;

import java.util.*;

public class SerieExemplo {
    public static void main(String[] args) {
        final Serie got = new Serie("Got", "Ficção", 45);
        final Serie thirdyReasonsWhy = new Serie("TRW", "Drama", 60);
        final Serie quantico = new Serie("Quantico", "Ação", 40);
        final Serie oz = new Serie("Oz", "Psicológico", 45);

         Set<Serie> setSeries = new HashSet<Serie>(){{
            add(got);
            add(thirdyReasonsWhy);
            add(quantico);
            add(oz);
        }};

        System.out.println("Ordem Aleatória (HashSet): ");
        System.out.println(setSeries);

        Set<Serie> linkedSetSeries = new LinkedHashSet<Serie>(Arrays.asList(got, thirdyReasonsWhy, quantico, oz));
        System.out.println("Mantendo a ordem de inserção (LinkedHashSet: ");
        System.out.println(linkedSetSeries);

        System.out.println("Colocando em ordem crescente por tamanho do episódio, gênero e nome (alterando a classe " +
                "serie, implementando a interface Comparable e o método compareTo");
        Set<Serie> treeSetSeries = new TreeSet<Serie>();
        treeSetSeries.addAll(setSeries);
        System.out.println(treeSetSeries);
        System.out.println("Agora ordenando pelo gênero e tamanho do episódio: implementando o comparator" +
                "CompratorGeneroTempoEpisodio e passando como argumento do construtor da TreeSet ");
        Set<Serie> treeSetSeriesComparator = new TreeSet<Serie>(new ComparatorGeneroTempoEpisodio());
        treeSetSeriesComparator.addAll(setSeries);
        System.out.println(( treeSetSeriesComparator));
        System.out.println("Alterando a ordem dos elementos anteriores: ");
        System.out.println(((TreeSet<Serie>) treeSetSeriesComparator).descendingSet());


    }
}

class ComparatorGeneroTempoEpisodio implements Comparator<Serie>{

    @Override
    public int compare(Serie o1, Serie o2) {
        int comparacaoGenero = o1.getGenero().compareTo(o2.getGenero());
        if(comparacaoGenero!=0)
            return comparacaoGenero;
        return Integer.compare(o1.getTempoEpisodio(),o2.getTempoEpisodio());

    }

}
