package ru.mihail.spring.ispi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mihail.spring.ispi.models.Specialty;
import ru.mihail.spring.ispi.repositories.SpecialtyRepository;

import java.util.Optional;

@Service
public class SpecialtyService {

    @Autowired
    private SpecialtyRepository specialtyRepository;

    public void addSpecialty(Specialty specialty) {
        specialtyRepository.save(specialty);
    }
    public Specialty findById(Long id) {
        Optional<Specialty> specialtyOptional = specialtyRepository.findById(id);
        return specialtyOptional.orElse(null);
    }
}