package com.duocdevs.asistrack.service;

import com.duocdevs.asistrack.model.IncidentType;
import com.duocdevs.asistrack.repository.IncidentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidentTypeService {

    @Autowired
    private IncidentTypeRepository incidentTypeRepository;

    public List<IncidentType> getAllIncidentTypes() {
        return incidentTypeRepository.findAll();
    }

    public IncidentType saveIncidentType(IncidentType type) {
        return incidentTypeRepository.save(type);
    }

    public IncidentType getIncidentTypeById(Integer id) {
        return incidentTypeRepository.findById(id).orElse(null);
    }

    public void deleteIncidentType(Integer id) {
        incidentTypeRepository.deleteById(id);
    }
}