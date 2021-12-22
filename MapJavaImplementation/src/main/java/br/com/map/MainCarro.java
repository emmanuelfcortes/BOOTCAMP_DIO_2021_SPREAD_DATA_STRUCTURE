package br.com.map;

import java.util.*;


public class MainCarro {
    public static void main(String[] args) {
        final Carro carro1 = new Carro("palio", 14.5d);
        final Carro carro2 = new Carro("gol", 14.5d);
        final Carro carro3 = new Carro("uno", 15.6d);
        final Carro carro4 = new Carro("mobi", 16.3d);


        Map<String, Double> carrosPopulares = new HashMap<String, Double>() {{
            put(carro1.getModelo(), carro1.getConsumo());
            put(carro2.getModelo(), carro2.getConsumo());
            put(carro3.getModelo(), carro3.getConsumo());
            put(carro4.getModelo(), carro4.getConsumo());
        }};
        System.out.println("População inicial do Map de carros e consumo: ");
        System.out.println(carrosPopulares);

        System.out.print("Recuperar o consumo do gol: ");
        System.out.println(carrosPopulares.get("gol"));

        System.out.print("Pesquisar se existe o carro \"tucson\" no map: ");
        System.out.println(carrosPopulares.containsKey("tucson"));

        System.out.print("Retornar todos os modelos de carros (chaves): ");
        Set<String> carros = carrosPopulares.keySet();
        System.out.println(carros);

        System.out.print("Retornar todos os consumos dos carros (valores): ");
        Collection<Double> consumos = carrosPopulares.values();
        System.out.println(consumos);

        System.out.print("Qual o menor consumo?  ");
        System.out.println(Collections.min(consumos));

        System.out.print("Qual o maior consumo?  ");
        System.out.println(Collections.max(consumos));

        System.out.println("Qual(is) o(s) modelo(s) com menor consumo: ");

        Double menorEficiencia = Collections.min(consumos);
        Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();
        for (Map.Entry<String, Double> entrie : entries) {
//                System.out.println("Avaliando o modelo: "+entrie);
//                Double c = entrie.getValue();
//                boolean comparacao = (c.equals(menorEficiencia));
//            System.out.println("Comparação entre "+c+" e " + menorEficiencia+" = "+comparacao);
//             utilizando c == menorEficiencia, mesmo com todos os elementos do Set sendo iguais,
//             apenas o primeiro elemento do Set retornou true na comparação.
            if (entrie.getValue().equals(menorEficiencia)){
                System.out.println("Modelo: " + entrie.getKey() + ", Consumo: " + entrie.getValue());
            }


        }
    /*  Essa implementação retorna um erro, pois o Map não aceita o método forEach()

        for(Map<String, Double> map : carrosPopulares){

        }*/
        System.out.print("Tirando uma média dos consumos entre os carros: ");
        Collection< Double> valores = carrosPopulares.values();
        Iterator<Double> valoresIterator = valores.iterator();
        Double soma=0d;
        while(valoresIterator.hasNext()){
            soma += valoresIterator.next();
        }
        Double media = soma/ carrosPopulares.size();
        System.out.println(media);
        System.out.println("Removendo os carros abaixo da média: "+ media);
        System.out.println("Valores iniciais: ");
        System.out.println(carrosPopulares);
        Set <Map.Entry<String, Double>> entries2 = carrosPopulares.entrySet();

        Iterator<Map.Entry<String, Double>> iterator2 = entries.iterator();

        /*Quando você tenta modificar uma Collection em um laço (remover), de alguma forma fora do Iterator,
        * é gerado um erro de execução ConcurrentModificationException
        * */

        Set<String> keys = carrosPopulares.keySet();
        Iterator< String> it = keys.iterator();
        while(iterator2.hasNext()){
            if(iterator2.next().getValue() < media)
                iterator2.remove();
        }
        System.out.println("Valores após exclusão: ");
        System.out.println(carrosPopulares);

        System.out.println("Imprimindo valores na ordem que foram inseridos (LinkedHashMap)");

        Map<String, Double> carrosPopulares2 = new LinkedHashMap<String, Double>() {{
            put(carro1.getModelo(), carro1.getConsumo());
            put(carro2.getModelo(), carro2.getConsumo());
            put(carro3.getModelo(), carro3.getConsumo());
            put(carro4.getModelo(), carro4.getConsumo());
        }};
        System.out.println(carrosPopulares2);

        System.out.println("Ordenando os carros pelo modelo (TreeMap) ");
        Map<String, Double> carrosPopulares3 = new TreeMap<String, Double>() {{
            put(carro1.getModelo(), carro1.getConsumo());
            put(carro2.getModelo(), carro2.getConsumo());
            put(carro3.getModelo(), carro3.getConsumo());
            put(carro4.getModelo(), carro4.getConsumo());
        }};
        System.out.println(carrosPopulares3);

        System.out.println("Apgando tudo!!!");
        carrosPopulares3.clear();
        System.out.println(carrosPopulares3);
    }



}
