package com.duocdevs.asistrack.controller;

import com.duocdevs.asistrack.model.IncidentType;
import com.duocdevs.asistrack.service.IncidentTypeService;
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
@RequestMapping("api/v1/incident-type")
@Tag(name = "IncidentType", description = "Tipos de incidentes")
public class IncidentTypeController {

    @Autowired
    private IncidentTypeService incidentTypeService;

    @GetMapping
    @Operation(summary = "Obtener tipos de incidentes")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Listado obtenido",
                    content = @Content(schema = @Schema(implementation = IncidentType.class)))
    })
    public List<IncidentType> getAll() {
        return incidentTypeService.getAllIncidentTypes();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener tipo de incidente por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Tipo encontrado",
                    content = @Content(schema = @Schema(implementation = IncidentType.class))),
            @ApiResponse(responseCode = "404", description = "Tipo no encontrado")
    })
    public IncidentType getById(@PathVariable Integer id) {
        return incidentTypeService.getIncidentTypeById(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar tipo de incidente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Tipo actualizado",
                    content = @Content(schema = @Schema(implementation = IncidentType.class))),
            @ApiResponse(responseCode = "404", description = "Tipo no encontrado")
    })
    public IncidentType update(@PathVariable Integer id, @RequestBody IncidentType type) {
        IncidentType existing = incidentTypeService.getIncidentTypeById(id);

        existing.setIdTyeIn(type.getIdTyeIn());
        existing.setType(type.getType());
        existing.setIncidents(type.getIncidents());

        return incidentTypeService.saveIncidentType(existing);
    }

    @PostMapping
    @Operation(summary = "Crear tipo de incidente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Tipo creado",
                    content = @Content(schema = @Schema(implementation = IncidentType.class)))
    })
    public IncidentType save(@RequestBody IncidentType type) {
        return incidentTypeService.saveIncidentType(type);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar tipo de incidente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Tipo eliminado"),
            @ApiResponse(responseCode = "404", description = "Tipo no encontrado")
    })
    public void delete(@PathVariable Integer id) {
        incidentTypeService.deleteIncidentType(id);
    }
}
