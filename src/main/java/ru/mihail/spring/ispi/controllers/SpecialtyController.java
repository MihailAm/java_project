package ru.mihail.spring.ispi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.mihail.spring.ispi.models.Specialty;
import ru.mihail.spring.ispi.services.SpecialtyService;

@Controller
@RequestMapping("api/spec")
public class SpecialtyController {
    @Autowired
    private SpecialtyService specialtyService;

    @PostMapping("/add")
    public ResponseEntity<String> addSpecialty(@RequestBody Specialty specialty) {
        specialtyService.addSpecialty(specialty);
        return ResponseEntity.ok("Specialty added successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Specialty> getSpecialtyById(@PathVariable Long id) {
        Specialty specialty = specialtyService.findById(id);
        if (specialty != null) {
            return new ResponseEntity<>(specialty, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
