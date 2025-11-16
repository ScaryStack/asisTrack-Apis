package com.duocdevs.asistrack.controller;

import com.duocdevs.asistrack.model.IncidentType;
import com.duocdevs.asistrack.service.IncidentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/incident-type")
public class IncidentTypeController {

    @Autowired
    private IncidentTypeService incidentTypeService;

    @GetMapping
    public List<IncidentType> getAll() {
        return incidentTypeService.getAllIncidentTypes();
    }

    @GetMapping("/{id}")
    public IncidentType getById(@PathVariable Integer id) {
        return incidentTypeService.getIncidentTypeById(id);
    }

    @PostMapping
    public IncidentType save(@RequestBody IncidentType type) {
        return incidentTypeService.saveIncidentType(type);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        incidentTypeService.deleteIncidentType(id);
    }
}