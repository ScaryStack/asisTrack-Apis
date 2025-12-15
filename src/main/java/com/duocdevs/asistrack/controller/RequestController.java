package com.duocdevs.asistrack.controller;

import com.duocdevs.asistrack.model.Request;
import com.duocdevs.asistrack.service.RequestService;
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
@RequestMapping("api/v1/request")
@Tag(name = "Request", description = "Solicitudes del sistema")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @GetMapping
    @Operation(summary = "Obtener solicitudes")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Listado de solicitudes",
                    content = @Content(schema = @Schema(implementation = Request.class)))
    })
    public List<Request> getAll() {
        return requestService.getAllRequests();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener solicitud por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Solicitud encontrada",
                    content = @Content(schema = @Schema(implementation = Request.class))),
            @ApiResponse(responseCode = "404", description = "Solicitud no encontrada")
    })
    public Request getById(@PathVariable Integer id) {
        return requestService.getRequestById(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar solicitud")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Solicitud actualizada",
                    content = @Content(schema = @Schema(implementation = Request.class))),
            @ApiResponse(responseCode = "404", description = "Solicitud no encontrada")
    })
    public Request update(@PathVariable Integer id, @RequestBody Request request) {
        Request existing = requestService.getRequestById(id);

        existing.setIdRequest(request.getIdRequest());
        existing.setCreationDate(request.getCreationDate());
        existing.setStatus(request.getStatus());
        existing.setUser(request.getUser());
        existing.setVacation(request.getVacation());
        existing.setPermission(request.getPermission());
        existing.setRequestType(request.getRequestType());

        return requestService.saveRequest(existing);
    }

    @PostMapping
    @Operation(summary = "Crear solicitud")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Solicitud creada",
                    content = @Content(schema = @Schema(implementation = Request.class)))
    })
    public Request save(@RequestBody Request request) {
        return requestService.saveRequest(request);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar solicitud")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Solicitud eliminada"),
            @ApiResponse(responseCode = "404", description = "Solicitud no encontrada")
    })
    public void delete(@PathVariable Integer id) {
        requestService.deleteRequest(id);
    }
}
