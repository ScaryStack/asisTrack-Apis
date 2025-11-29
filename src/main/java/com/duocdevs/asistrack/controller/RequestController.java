package com.duocdevs.asistrack.controller;

import com.duocdevs.asistrack.model.Request;
import com.duocdevs.asistrack.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/request")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @GetMapping
    public List<Request> getAll() {
        return requestService.getAllRequests();
    }

    @GetMapping("/{id}")
    public Request getById(@PathVariable Integer id) {
        return requestService.getRequestById(id);
    }

    @PutMapping("/{id}")
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
    public Request save(@RequestBody Request request) {
        return requestService.saveRequest(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        requestService.deleteRequest(id);
    }
}