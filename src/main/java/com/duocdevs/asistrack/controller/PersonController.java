package com.duocdevs.asistrack.controller;

import com.duocdevs.asistrack.model.Person;
import com.duocdevs.asistrack.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public List<Person> getAll() {
        return personService.getAllPersons();
    }

    @GetMapping("/{id}")
    public Person getById(@PathVariable Integer id) {
        return personService.getPersonById(id);
    }

    @PutMapping("/{id}")
    public Person update(@PathVariable Integer id, @RequestBody Person person) {

        // 1. Obtener persona existente
        Person existing = personService.getPersonById(id);

        // 2. Actualizar los campos (sin tocar IDs)
        existing.setRut(person.getRut());
        existing.setName(person.getName());
        existing.setPhone(person.getPhone());
        existing.setCompany(person.getCompany());

        // Si actualizas users también:
        existing.setUsers(person.getUsers());

        // 3. Guardar
        return personService.savePerson(existing);
    }

    @PostMapping
    public Person save(@RequestBody Person person) {
        return personService.savePerson(person);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        personService.deletePerson(id);
    }
}