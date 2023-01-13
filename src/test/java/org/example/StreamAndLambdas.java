package org.example;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.example.StreamAndLambdas.Gender.FEMALE;
import static org.example.StreamAndLambdas.Gender.MALE;


public class StreamAndLambdas {


    @Test
    void listPeople() {

        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Khalid", MALE),
                new Person("Marianne", FEMALE),
                new Person("Angry Joe", MALE),
                new Person("Dirty Dianna", FEMALE),
                new Person("Joe Mane", MALE)
        );

        List<Person> males = people.stream().filter(person -> person.gender == MALE).collect(Collectors.toList());
        List<Person> females = people.stream().filter(person -> person.gender == FEMALE).collect(Collectors.toList());

        listMales(males);
        listMalesWhoseNameContainsJo(males);


    }

    public static class Person {
        private String name;
        private Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }


    }

    static enum Gender {
        MALE,
        FEMALE
    }

    private static void listMales(List<Person> males) {
        System.out.println("You have the following males in your list : ");
        males.stream().forEach(person -> System.out.println(person.name));
    }

    private static void listMalesWhoseNameContainsJo(List<Person> males) {
        System.out.println(" ++ Males whose name contains the word 'Jo' ");
        males.stream().filter(e -> e.name.contains("Jo"))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
    
}
