package ru.mihail.spring.ispi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.mihail.spring.ispi.models.Doctor;
import ru.mihail.spring.ispi.models.Specialty;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    // Метод для сохранения доктора
    Doctor save(Doctor doctor);

    // Метод для получения списка всех докторов
    List<Doctor> findAll();


}
