package com.duocdevs.asistrack.service;

import com.duocdevs.asistrack.model.Person;
import com.duocdevs.asistrack.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public Person getPersonById(Integer id) {
        return personRepository.findById(id).orElse(null);
    }

    public void deletePerson(Integer id) {
        personRepository.deleteById(id);
    }
}