package br.com.streamapi;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MainStudent {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>() {{
            add(new Student("jose", "Enginnering", 20));
            add(new Student("Ralph", "Eletronics", 25));
            add(new Student("Mary", "Robotics", 36));
            add(new Student("Jane", "Astrology", 45));
            add(new Student("Jim", "Phisics", 58));

        }};

        /**********************  StreamAPI ******************************/
        System.out.println("********* Working with StreamAPI");
        System.out.println("\nCounting the number of elements in students list: ");
        System.out.println(students.stream().count());
        System.out.println("\nReturning the max and min accord to the age: ");
        System.out.println("original  elements: ");
        System.out.println(students);
        System.out.println("Max anda Min element, for age: ");
        System.out.println("MAX: ");
        System.out.println(students.stream().max(Comparator.comparing((Student::getAge))));
        System.out.println("MIN: ");
        System.out.println(students.stream().min(Comparator.comparingInt(Student::getAge)));
        System.out.println("\nPrinting the students that name contains 'a': ");
        System.out.println(students.stream()
                .filter((s) -> s.getName().toLowerCase().contains("a"))
                .collect(Collectors.toList()));
//        System.out.println(students.stream().max(new Comparator<Student>() {
//            @Override
//            public int compare(Student s1, Student s2) {
//                return s1.getAge() - s2.getAge();
//            }
//        }));
        /****
         * O stream().forEach(Consumer()) will run the Consumer funcion for each element in a Collection
         * but don't return anything.
         *The stream.peek(Consumer) diferently from forEach() will run ther Consumer function to
         * each element, but return the same Collection that recepted.
         * The method peek only will function correctly if we pass collect(Collector) after that.
         * */

        System.out.println("\nPrinting names of students, usign stream().foreach(): ");
        students.stream().forEach(s -> System.out.println(s.getName()));
        System.out.println("\n Printing the 3 firsts students at list: ");
        students.stream().limit(3).forEach(System.out::println);
        System.out.println("\n Using the stream().peek() to print the students names and after the ages.");
        Student std = new Student();
        System.out.println(students.stream()
                .peek((s) -> System.out.print("Name: " + s.getName() + ", "))
                .peek((s) -> System.out.println("Age: " + s.getAge()))
                .collect(Collectors.toList())
        );
        System.out.println("\nVerifying if all ages are equals or higher than 18, with stream().allMatch(): ");
        System.out.println(students.stream().allMatch(s -> s.getAge() >= 18));

        System.out.println("\nVerifying if any age is higher than 60, with stream().anyMatch()");
        System.out.println(students.stream().anyMatch((s) -> s.getAge() > 60));

        System.out.println("\nVerifying if all elements don't have 'bab' at name, with stream().noneMatch(): ");
        System.out.println(students.stream().noneMatch((s) -> s.getName().contains("bab")));

        students.add(null);
        /** Getting the first element at list. Is is Empty, return "Empty"*/
        System.out.println("\nGetting the first element at list. If is Empty, return \"Empty\"");
        students.stream().findFirst().ifPresent(System.out::println);
        List<Student> students2 = new ArrayList<>();
        students2.addAll(students);
        /*** Using concatenated methods.
         * 1. Filter the null elements and remove;
         * 2.Transforming all students course Adding "Bachelor";
         * 2. Print on screen all the student list
         * 3. Group the students by name first character.
         *
         * */

        System.out.println(students2.stream()
                //.map(s->s.setCourse(s.getCourse()+" Bachelor"))
                .filter((s) -> s != null)
                .map((s) -> {
                    Student s2 = new Student(s.getName(), s.getCourse() + " Bachelor", s.getAge());
                    return s2;
                })
                .peek(System.out::println)
                .collect(Collectors.groupingBy((s) -> s.getName().substring(0))));
    }
}
