package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        persons.add(person);
    }

    public List<Person> find(String key) {
        Predicate<Person> name = person -> person.getName().contains(key);
        Predicate<Person> surname = person -> person.getSurname().contains(key);
        Predicate<Person> phone = person -> person.getPhone().contains(key);
        Predicate<Person> address = person -> person.getAddress().contains(key);
        Predicate<Person> combine = name.or(surname).or(phone).or(address);
        return persons.stream().filter(combine).collect(Collectors.toList());
    }
}
