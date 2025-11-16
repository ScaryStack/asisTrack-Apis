package com.duocdevs.asistrack.service;

import com.duocdevs.asistrack.model.Vacation;
import com.duocdevs.asistrack.repository.VacationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacationService {

    @Autowired
    private VacationRepository vacationRepository;

    public List<Vacation> getAllVacations() {
        return vacationRepository.findAll();
    }

    public Vacation saveVacation(Vacation vacation) {
        return vacationRepository.save(vacation);
    }

    public Vacation getVacationById(Integer id) {
        return vacationRepository.findById(id).orElse(null);
    }

    public void deleteVacation(Integer id) {
        vacationRepository.deleteById(id);
    }
}