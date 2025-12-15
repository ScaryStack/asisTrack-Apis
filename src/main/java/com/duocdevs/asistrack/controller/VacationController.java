package com.duocdevs.asistrack.controller;

import com.duocdevs.asistrack.model.Vacation;
import com.duocdevs.asistrack.service.VacationService;
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
@RequestMapping("api/v1/vacation")
@Tag(name = "Vacation", description = "Vacaciones de usuarios")
public class VacationController {

    @Autowired
    private VacationService vacationService;

    @GetMapping
    @Operation(summary = "Obtener vacaciones")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Listado de vacaciones",
                    content = @Content(schema = @Schema(implementation = Vacation.class)))
    })
    public List<Vacation> getAll() {
        return vacationService.getAllVacations();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener vacaciones por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Vacación encontrada",
                    content = @Content(schema = @Schema(implementation = Vacation.class))),
            @ApiResponse(responseCode = "404", description = "Vacación no encontrada")
    })
    public Vacation getById(@PathVariable Integer id) {
        return vacationService.getVacationById(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar vacaciones")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Vacación actualizada",
                    content = @Content(schema = @Schema(implementation = Vacation.class))),
            @ApiResponse(responseCode = "404", description = "Vacación no encontrada")
    })
    public Vacation update(@PathVariable Integer id, @RequestBody Vacation vacation) {
        Vacation existing = vacationService.getVacationById(id);

        existing.setIdVacation(vacation.getIdVacation());
        existing.setRequest(vacation.getRequest());
        existing.setDateFinish(vacation.getDateFinish());
        existing.setDateStart(vacation.getDateStart());
        existing.setDaysAvailable(vacation.getDaysAvailable());

        return vacationService.saveVacation(existing);
    }

    @PostMapping
    @Operation(summary = "Crear vacaciones")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Vacación creada",
                    content = @Content(schema = @Schema(implementation = Vacation.class)))
    })
    public Vacation save(@RequestBody Vacation vacation) {
        return vacationService.saveVacation(vacation);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar vacaciones")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Vacación eliminada"),
            @ApiResponse(responseCode = "404", description = "Vacación no encontrada")
    })
    public void delete(@PathVariable Integer id) {
        vacationService.deleteVacation(id);
    }
}
