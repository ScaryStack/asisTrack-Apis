package com.duocdevs.asistrack.controller;

import com.duocdevs.asistrack.model.Person;
import com.duocdevs.asistrack.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/person")
@Tag(name = "Person", description = "Personas del sistema")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    @Operation(summary = "Obtener personas")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Listado de personas",
                    content = @Content(schema = @Schema(implementation = Person.class)))
    })
    public List<Person> getAll() {
        return personService.getAllPersons();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener persona por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Persona encontrada",
                    content = @Content(schema = @Schema(implementation = Person.class))),
            @ApiResponse(responseCode = "404", description = "Persona no encontrada")
    })
    public Person getById(@PathVariable Integer id) {
        return personService.getPersonById(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar persona")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Persona actualizada",
                    content = @Content(schema = @Schema(implementation = Person.class))),
            @ApiResponse(responseCode = "404", description = "Persona no encontrada")
    })
    public Person update(@PathVariable Integer id, @RequestBody Person person) {
        Person existing = personService.getPersonById(id);

        existing.setRut(person.getRut());
        existing.setName(person.getName());
        existing.setPhone(person.getPhone());
        existing.setCompany(person.getCompany());
        existing.setUsers(person.getUsers());

        return personService.savePerson(existing);
    }

    @PostMapping
    @Operation(summary = "Crear persona")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Persona creada",
                    content = @Content(schema = @Schema(implementation = Person.class)))
    })
    public Person save(@RequestBody Person person) {
        return personService.savePerson(person);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar persona")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Persona eliminada"),
            @ApiResponse(responseCode = "404", description = "Persona no encontrada")
    })
    public void delete(@PathVariable Integer id) {
        personService.deletePerson(id);
    }
}
