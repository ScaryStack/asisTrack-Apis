package com.duocdevs.asistrack.controller;

import com.duocdevs.asistrack.model.Incident;
import com.duocdevs.asistrack.service.IncidentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/incident")
@Tag(name = "Incident", description = "Operaciones relacionadas con incidentes")
public class IncidentController {

    @Autowired
    private IncidentService incidentService;

    @GetMapping
    @Operation(summary = "Obtener todos los incidentes")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Listado de incidentes",
                    content = @Content(schema = @Schema(implementation = Incident.class)))
    })
    public List<Incident> getAll() {
        return incidentService.getAllIncidents();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener incidente por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Incidente encontrado",
                    content = @Content(schema = @Schema(implementation = Incident.class))),
            @ApiResponse(responseCode = "404", description = "Incidente no encontrado")
    })
    public Incident getById(@PathVariable Integer id) {
        return incidentService.getIncidentById(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar incidente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Incidente actualizado",
                    content = @Content(schema = @Schema(implementation = Incident.class))),
            @ApiResponse(responseCode = "404", description = "Incidente no encontrado")
    })
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
    @Operation(summary = "Crear incidente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Incidente creado",
                    content = @Content(schema = @Schema(implementation = Incident.class)))
    })
    public Incident save(@RequestBody Incident incident) {
        return incidentService.saveIncident(incident);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar incidente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Incidente eliminado"),
            @ApiResponse(responseCode = "404", description = "Incidente no encontrado")
    })
    public void delete(@PathVariable Integer id) {
        incidentService.deleteIncident(id);
    }
}
