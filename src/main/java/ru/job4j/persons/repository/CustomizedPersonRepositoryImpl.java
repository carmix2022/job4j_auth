package ru.job4j.persons.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.persons.model.Person;

import java.util.Optional;
@Repository
public class CustomizedPersonRepositoryImpl implements CustomizedPersonRepository {

    private final SessionFactory sessionFactory;
    private static final Logger LOG = LoggerFactory.getLogger(CustomizedPersonRepositoryImpl.class.getName());

    public CustomizedPersonRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    @Override
    public Optional<Person> saveEntity(Person candidate) {
        Session session = sessionFactory.openSession();
        try (session) {
            Transaction currentTransaction = session.beginTransaction();
            session.persist(candidate);
            currentTransaction.commit();
            return Optional.of(candidate);
        } catch (Exception e) {
            session.getTransaction().rollback();
            LOG.error("Exception during saving or updating", e);
        }
        return Optional.empty();
    }

    @Transactional
    @Override
    public boolean deleteEntity(Person candidate) {
        Session session = sessionFactory.openSession();
        try (session) {
            Transaction currentTransaction = session.beginTransaction();
            session.remove(candidate);
            currentTransaction.commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            LOG.error("Exception during deleting", e);
        }
        return false;
    }
}
