package ru.job4j.persons.service;

import ru.job4j.persons.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    Optional<Person> save(Person candidate);

    boolean delete(Person person);

    Optional<Person> findById(int id);

    List<Person> findAll();
}
