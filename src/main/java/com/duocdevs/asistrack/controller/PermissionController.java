package com.duocdevs.asistrack.controller;

import com.duocdevs.asistrack.model.Permission;
import com.duocdevs.asistrack.service.PermissionService;
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
@RequestMapping("api/v1/permission")
@Tag(name = "Permission", description = "Permisos solicitados por usuarios")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @GetMapping
    @Operation(summary = "Obtener permisos")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Listado de permisos",
                    content = @Content(schema = @Schema(implementation = Permission.class)))
    })
    public List<Permission> getAll() {
        return permissionService.getAllPermissions();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener permiso por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Permiso encontrado",
                    content = @Content(schema = @Schema(implementation = Permission.class))),
            @ApiResponse(responseCode = "404", description = "Permiso no encontrado")
    })
    public Permission getById(@PathVariable Integer id) {
        return permissionService.getPermissionById(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar permiso")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Permiso actualizado",
                    content = @Content(schema = @Schema(implementation = Permission.class))),
            @ApiResponse(responseCode = "404", description = "Permiso no encontrado")
    })
    public Permission update(@PathVariable Integer id, @RequestBody Permission permission) {
        Permission existing = permissionService.getPermissionById(id);

        existing.setIdPermission(permission.getIdPermission());
        existing.setRequest(permission.getRequest());
        existing.setDate(permission.getDate());
        existing.setHour(permission.getHour());
        existing.setReason(permission.getReason());

        return permissionService.savePermission(existing);
    }

    @PostMapping
    @Operation(summary = "Crear permiso")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Permiso creado",
                    content = @Content(schema = @Schema(implementation = Permission.class)))
    })
    public Permission save(@RequestBody Permission permission) {
        return permissionService.savePermission(permission);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar permiso")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Permiso eliminado"),
            @ApiResponse(responseCode = "404", description = "Permiso no encontrado")
    })
    public void delete(@PathVariable Integer id) {
        permissionService.deletePermission(id);
    }
}
