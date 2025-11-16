package com.duocdevs.asistrack.controller;

import com.duocdevs.asistrack.model.Configuration;
import com.duocdevs.asistrack.service.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/configuration")
public class ConfigurationController {

    @Autowired
    private ConfigurationService configurationService;

    @GetMapping
    public List<Configuration> getAll() {
        return configurationService.getAllConfigurations();
    }

    @GetMapping("/{id}")
    public Configuration getById(@PathVariable Integer id) {
        return configurationService.getConfigurationById(id);
    }

    @PostMapping
    public Configuration save(@RequestBody Configuration config) {
        return configurationService.saveConfiguration(config);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        configurationService.deleteConfiguration(id);
    }
}