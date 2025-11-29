package com.duocdevs.asistrack.controller;

import com.duocdevs.asistrack.model.Permission;
import com.duocdevs.asistrack.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @GetMapping
    public List<Permission> getAll() {
        return permissionService.getAllPermissions();
    }

    @GetMapping("/{id}")
    public Permission getById(@PathVariable Integer id) {
        return permissionService.getPermissionById(id);
    }


    @PutMapping("/{id}")
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
    public Permission save(@RequestBody Permission permission) {
        return permissionService.savePermission(permission);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        permissionService.deletePermission(id);
    }
}