package com.duocdevs.asistrack.controller;

import com.duocdevs.asistrack.model.Vacation;
import com.duocdevs.asistrack.service.VacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/vacation")
public class VacationController {

    @Autowired
    private VacationService vacationService;

    @GetMapping
    public List<Vacation> getAll() {
        return vacationService.getAllVacations();
    }

    @GetMapping("/{id}")
    public Vacation getById(@PathVariable Integer id) {
        return vacationService.getVacationById(id);
    }

    @PutMapping("/{id}")
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
    public Vacation save(@RequestBody Vacation vacation) {
        return vacationService.saveVacation(vacation);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        vacationService.deleteVacation(id);
    }
}