package com.duocdevs.asistrack.service;

import com.duocdevs.asistrack.model.Incident;
import com.duocdevs.asistrack.repository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidentService {

    @Autowired
    private IncidentRepository incidentRepository;

    public List<Incident> getAllIncidents() {
        return incidentRepository.findAll();
    }

    public Incident saveIncident(Incident incident) {
        return incidentRepository.save(incident);
    }

    public Incident getIncidentById(Integer id) {
        return incidentRepository.findById(id).orElse(null);
    }

    public void deleteIncident(Integer id) {
        incidentRepository.deleteById(id);
    }
}