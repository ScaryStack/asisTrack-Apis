package com.duocdevs.asistrack.service;

import com.duocdevs.asistrack.model.Configuration;
import com.duocdevs.asistrack.repository.ConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigurationService {

    @Autowired
    private ConfigurationRepository configurationRepository;

    public List<Configuration> getAllConfigurations() {
        return configurationRepository.findAll();
    }

    public Configuration saveConfiguration(Configuration config) {
        return configurationRepository.save(config);
    }

    public Configuration getConfigurationById(Integer id) {
        return configurationRepository.findById(id).orElse(null);
    }

    public void deleteConfiguration(Integer id) {
        configurationRepository.deleteById(id);
    }
}