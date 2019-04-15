package Predicates;

import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args)
    {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Сергей", 38));
        persons.add(new Person("Даша", 7));
        persons.add(new Person("Глаша", 3));
        persons.add(new Person("Саша", 6));
        persons.add(new Person("Анна", 18));

        int summa = 0;
        int adultPersons = 0;
        for(Person p : persons)
            if (p.getAge() >= 18) {
                summa += p.getAge();
                adultPersons++;
            }
        double averageAge = (double)summa/adultPersons;
        System.out.println(averageAge);

        double averageAge2 = persons.stream().
                filter( p -> p.getAge() >= 18).
                mapToInt( p -> p.getAge()).average().getAsDouble();
        System.out.println(averageAge2);

//        for(Person p : persons)
//            System.out.println(p);
//
//
//
//        persons.stream().forEach( p -> System.out.println(p) );
//
//        persons.stream().forEach(System.out::println);

        persons.stream().
                filter( p -> p.getAge() >= 18 ).
                sorted( (p1, p2) -> p2.getName().compareTo(p1.getName()) ).
                map( p -> p.getName() ).
                forEach(
                        //(String name) -> System.out.println(name)

                        System.out::println

                        );
    }
}
