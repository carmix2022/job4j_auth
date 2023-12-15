package ru.job4j.persons.service;

import org.springframework.stereotype.Service;
import ru.job4j.persons.model.Person;
import ru.job4j.persons.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SimplePersonService implements PersonService {

    private final PersonRepository persons;

    public SimplePersonService(final PersonRepository personRepository) {
        this.persons = personRepository;
    }

    @Override
    public Optional<Person> save(Person candidate) {
        return persons.saveEntity(candidate);
    }

    @Override
    public boolean delete(Person candidate) {
        return persons.deleteEntity(candidate);
    }

    @Override
    public Optional<Person> findById(int id) {
        return persons.findById(id);
    }

    @Override
    public List<Person> findAll() {
        return persons.findAll();
    }
}
