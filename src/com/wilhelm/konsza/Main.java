package com.wilhelm.konsza;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Person> people = getPeople();

        // Imperative no-no way from which experienced programmers start crying
        List<Person> females = new ArrayList<>();

        for (Person p : people
        ) {
            if (p.getGender().equals(Gender.FEMALE)) {
                females.add(p);
            }
        }

        females.forEach(System.out::println);

        //Declarative approach, much superior plus iq points and all the women will like you for it (allegedly)
        System.out.println();

        //Filter -> takes a predicate which returns true or false
        List<Person> femalesDeclarative =
                people.stream().filter(person -> person.getGender().equals(Gender.FEMALE)).collect(Collectors.toList());
        femalesDeclarative.forEach(System.out::println);

        //Sort
        System.out.println();
        List<Person> sortedPeople = new ArrayList<>();
        sortedPeople = people.stream()
                .sorted(Comparator.comparing(Person::getAge)).collect(Collectors.toList());
//                .sorted(new Comparator<Person>() {
//                    @Override
//                    public int compare(Person o1, Person o2) {
//                        return o1.getAge() - o2.getAge();
//                    }
//                }.reversed())
//                .collect(Collectors.toList());
        sortedPeople.forEach(System.out::println);

        //All Match checks if every obj from a list completes a condition, takes in a predicate
        System.out.println("Checking if every person from list is older than 5y with allMatch: ");
        System.out.println(people.stream().allMatch(person -> person.getAge() > 5));

        //Any Match same as above, looks for individuals that complete a condition instead
        System.out.println("Checking if anyone completes a particular condition with anyMatch:");
        System.out.println(people.stream().anyMatch(person -> person.getSpecies().equals(Species.WHALE)));

        //noneMatch -> self explanatory same as above, won't bother

        //Max -> max value within a collection, returns an optional, takes a comparator
        System.out.println("Oldest person with Max: ");
        people.stream().max(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);


        //Min -> same as above, takes a comparator, returns Optional

        //Group -> grouping based on a field
        System.out.println("\nGrouping by gender: ");
        Map<Gender, List<Person>> groupedByGender =
                people.stream()
                        .collect(Collectors.groupingBy(Person::getGender));

        groupedByGender.forEach((gender, people1) -> {
            System.out.println(gender);
            people1.forEach(System.out::println);
        });

        //chaining functions
        Optional<String> oldestFemale =
                people.stream().filter(person -> person.getGender().equals(Gender.FEMALE))
                        .max(Comparator.comparing(Person::getAge))
                        .map(Person::getName);
        oldestFemale.ifPresent(System.out::println);
    }

    private static List<Person> getPeople() {
        return List.of(
                new Person("James Bond", 007, Gender.MALE),
                new Person("Your Mom", 1000, Species.WHALE),
                new Person("Konsza Wilhelm", 25, Gender.MALE),
                new Person("Duca Lili", 23, Gender.FEMALE),
                new Person("Mari Di", 25, Gender.FEMALE),
                new Person("Jenni Smith", 30, Gender.FEMALE),
                new Person("Khebab Armageddon", 28, Gender.MALE),
                new Person("Connor Gimmeyourbelt Mcgregor", 30, Gender.MALE),
                new Person("Iam Batman", 45, Gender.MALE),
                new Person("Clark Kent", 125, Gender.MALE),
                new Person("Tim Buchalka", 45, Gender.MALE),
                new Person("Amigos Code", 24, Gender.MALE)
        );
    }
}
