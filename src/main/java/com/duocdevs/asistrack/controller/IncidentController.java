package com.duocdevs.asistrack.controller;

import com.duocdevs.asistrack.model.Incident;
import com.duocdevs.asistrack.service.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/incident")
public class IncidentController {

    @Autowired
    private IncidentService incidentService;

    @GetMapping
    public List<Incident> getAll() {
        return incidentService.getAllIncidents();
    }

    @GetMapping("/{id}")
    public Incident getById(@PathVariable Integer id) {
        return incidentService.getIncidentById(id);
    }

    @PutMapping("/{id}")
    public Incident update(@PathVariable Integer id, @RequestBody Incident incident) {
        Incident existing = incidentService.getIncidentById(id);

        existing.setIdIncident(incident.getIdIncident());
        existing.setHour(incident.getHour());
        existing.setDate(incident.getDate());
        existing.setReason(incident.getReason());
        existing.setUser(incident.getUser());
        existing.setIncidentType(incident.getIncidentType());

        return incidentService.saveIncident(existing);
    }


    @PostMapping
    public Incident save(@RequestBody Incident incident) {
        return incidentService.saveIncident(incident);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        incidentService.deleteIncident(id);
    }
}