package com.duocdevs.asistrack.controller;

import com.duocdevs.asistrack.model.Configuration;
import com.duocdevs.asistrack.service.ConfigurationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/configuration")
@Tag(name = "Configuration", description = "Configuraciones del usuario")
public class ConfigurationController {

    @Autowired
    private ConfigurationService configurationService;

    @GetMapping
    @Operation(summary = "Obtener configuraciones")
    @ApiResponse(responseCode = "200", description = "Listado obtenido",
            content = @Content(schema = @Schema(implementation = Configuration.class)))
    public List<Configuration> getAll() {
        return configurationService.getAllConfigurations();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener configuración por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Configuración encontrada",
                    content = @Content(schema = @Schema(implementation = Configuration.class))),
            @ApiResponse(responseCode = "404", description = "Configuración no encontrada")
    })
    public Configuration getById(@PathVariable Integer id) {
        return configurationService.getConfigurationById(id);
    }

    @PostMapping
    @Operation(summary = "Crear configuración")
    @ApiResponse(responseCode = "200", description = "Configuración creada",
            content = @Content(schema = @Schema(implementation = Configuration.class)))
    public Configuration save(@RequestBody Configuration config) {
        return configurationService.saveConfiguration(config);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar configuración")
    public Configuration update(@PathVariable Integer id, @RequestBody Configuration config) {
        Configuration existing = configurationService.getConfigurationById(id);
        existing.setIdConfig(config.getIdConfig());
        existing.setUser(config.getUser());
        existing.setTheme(config.getTheme());
        return configurationService.saveConfiguration(existing);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar configuración")
    public void delete(@PathVariable Integer id) {
        configurationService.deleteConfiguration(id);
    }
}