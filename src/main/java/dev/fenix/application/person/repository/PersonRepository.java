package dev.fenix.application.person.repository;

import dev.fenix.application.person.module.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonRepository extends PagingAndSortingRepository<Person,Long> {
    Person getPersonById(Long id);
    Person save(Person person);
    void delete(Person person);
}

