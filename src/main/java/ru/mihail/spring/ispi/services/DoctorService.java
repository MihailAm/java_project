package ru.mihail.spring.ispi.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mihail.spring.ispi.models.Doctor;
import ru.mihail.spring.ispi.repositories.DoctorRepository;


import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DoctorService {
    // Заглушка для создания нового врача
    @Autowired
    private DoctorRepository doctorRepository;

    @Transactional
    public void save(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    // Заглушка для получения врача по его идентификатору (id)
    public Doctor getDoctorById(Long id) {
        // Реальная логика получения врача по id может быть добавлена здесь
        // Возвращаем заглушечный объект Doctor
        return new Doctor();
    }

    // Заглушка для получения списка всех врачей
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // Заглушка для обновления врача по id
    public Doctor updateDoctor(Doctor doctor) {
        // Логика обновления врача
        return new Doctor();
    }

    // Заглушка для удаления врача по id
    public void deleteDoctorById(Long id) {
        // Логика удаления врача
    }

    // Заглушка для поиска врачей по специальности
    public List<Doctor> searchDoctorsBySpecialty(String specialtyName) {
        // Логика поиска врачей по специальности

        return new ArrayList<>();
    }
}
