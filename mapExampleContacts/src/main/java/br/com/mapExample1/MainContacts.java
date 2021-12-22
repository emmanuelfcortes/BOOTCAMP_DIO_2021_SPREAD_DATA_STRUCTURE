package br.com.mapExample1;

import java.util.*;
import java.util.function.Function;

public class MainContacts {
    public static void main(String[] args) {
        System.out.println("Recebendo elementos e armazenando em ordem aleatória: (usando HashMap)");
        Map<Integer, Contact> contacts = new HashMap<Integer, Contact>();
        contacts.put(4, new Contact("John", "32324545"));
        contacts.put(3, new Contact("Mary", "99887766"));
        contacts.put(2, new Contact("Floid", "99990000"));
        contacts.put(1, new Contact("Floid", "88887125"));


        System.out.println("Contatos" + contacts);

        System.out.println("\nREcebendo elemento e armazenando na ordem dos id's: (usando LinkedHashMap");
        Map<Integer, Contact> contacts2 = new LinkedHashMap<Integer, Contact>();
        contacts2.put(4, new Contact("John", "32324545"));
        contacts2.put(3, new Contact("Mary", "99887766"));
        contacts2.put(2, new Contact("Floid", "99990000"));
        contacts2.put(1, new Contact("Floid", "88887125"));

        System.out.println(contacts2);

        System.out.println("\nREcebendo elemento e armazenando na ordem dos id's: (usando TreeMap)");
        Map<Integer, Contact> contacts3 = new TreeMap<Integer, Contact>();
        contacts3.putAll(contacts);
        System.out.println(contacts3);
        System.out.println("\nOrdenando pelos números de telefone: (usando Set e TreeSet ");

        //************************** implementação do Set com uso de um Comparator construído externamente, como uma
        // classe externa. ||
        //
        // Set< Map.Entry<Integer, Contact> > contacts4 = new TreeSet(new OrdenandoPortelefone());
        //
        // *************************************************************************************************

        //**************************  Segue abaixo, refatoração do código acima , usando Class anônima para
        // implementar o Comparator OrdenandoPorTelefone, ao invés de incluir uma classe separada no construtor:

        /*
        Set< Map.Entry<Integer, Contact> > contacts4 =
                new TreeSet<>(new Comparator<Map.Entry<Integer, Contact>>() {
            @Override
            public int compare(
                    Map.Entry<Integer, Contact> contact1,
                    Map.Entry<Integer, Contact> contact2) {
                return contact1.getValue().getTelefone().compareTo(contact2.getValue().getTelefone());
            }
        });
        ********************************************************************************************************
        */
        //******************************  implementação do Comparator usando  Functional Method ****************

//        ********************************************************************************************************

//        Set< Map.Entry<Integer, Contact> > contacts4 = new TreeSet<>( Comparator.comparing (
//                new Function<Map.Entry<Integer, Contact>, String>(){
//
//                    @Override
//                    public String apply(Map.Entry<Integer, Contact> entrie) {
//                        return entrie.getValue().getTelefone();
//                    }
//                }));
//        ********************************************************************************************************
//        ********** implementação utilizando Lambda funcion para implementação do Comparator (similar ao arrow function do Javascript


//        Set< Map.Entry<Integer, Contact> > contacts4 =
//                new TreeSet<>(
//                        (Map.Entry<Integer, Contact> contact1, Map.Entry<Integer, Contact> contact2) -> {
//
//                    return contact1.getValue().getTelefone().compareTo(contact2.getValue().getTelefone());
//
//                });

//        ********************************************************************************************************
//        ******************** Implementação utilizando lambda reduzido dentro do Comparator.comparing ***********
        Set< Map.Entry<Integer, Contact> > contacts4 =
                new TreeSet<>( Comparator.comparing( (contact) -> contact.getValue().getTelefone()));

//        ********************************************************************************************************

        contacts4.addAll(contacts.entrySet()) ;
        System.out.println(contacts4);

    }

}

class OrdenandoPortelefone implements Comparator<Map.Entry<Integer, Contact>> {


    @Override
    public int compare(Map.Entry<Integer, Contact> o1, Map.Entry<Integer, Contact> o2) {
        return o1.getValue().getTelefone().compareTo(o2.getValue().getTelefone());
    }
}
