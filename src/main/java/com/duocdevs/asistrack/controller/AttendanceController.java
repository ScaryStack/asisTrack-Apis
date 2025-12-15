package com.duocdevs.asistrack.controller;

import com.duocdevs.asistrack.model.Attendance;
import com.duocdevs.asistrack.service.AttendanceService;
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
@RequestMapping("api/v1/attendance")
@Tag(name = "Attendance", description = "Operaciones relacionadas con asistencias")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @GetMapping
    @Operation(summary = "Obtener todas las asistencias")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Listado obtenido",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Attendance.class)))
    })
    public List<Attendance> getAll() {
        return attendanceService.getAllAttendances();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener asistencia por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Asistencia encontrada",
                    content = @Content(schema = @Schema(implementation = Attendance.class))),
            @ApiResponse(responseCode = "404", description = "Asistencia no encontrada")
    })
    public Attendance getById(@PathVariable Integer id) {
        return attendanceService.getAttendanceById(id);
    }

    @PostMapping
    @Operation(summary = "Registrar asistencia")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Asistencia registrada",
                    content = @Content(schema = @Schema(implementation = Attendance.class)))
    })
    public Attendance save(@RequestBody Attendance attendance) {
        return attendanceService.saveAttendance(attendance);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar asistencia")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Asistencia eliminada"),
            @ApiResponse(responseCode = "404", description = "Asistencia no encontrada")
    })
    public void delete(@PathVariable Integer id) {
        attendanceService.deleteAttendance(id);
    }
}