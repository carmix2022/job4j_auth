package ru.job4j.persons.repository;

import ru.job4j.persons.model.Person;
import java.util.Optional;

public interface CustomizedPersonRepository {

    Optional<Person> saveEntity(Person candidate);

    boolean deleteEntity(Person person);
}
