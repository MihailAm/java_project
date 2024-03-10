package ru.mihail.spring.ispi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mihail.spring.ispi.models.Doctor;
import ru.mihail.spring.ispi.models.DoctorDTO;
import ru.mihail.spring.ispi.models.Specialty;
import ru.mihail.spring.ispi.models.Users;
import ru.mihail.spring.ispi.services.DoctorService;
import ru.mihail.spring.ispi.services.SpecialtyService;
import ru.mihail.spring.ispi.services.UsersService;

import java.util.List;

@Controller
@RequestMapping("api/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private SpecialtyService specialtyService;

    @GetMapping("/register")
    public String showDoctorRegistrationForm(Model model ) {
        try {
            model.addAttribute("doctor", new Doctor());
            return "doctor/doctor-registration-form";
        }
        catch (Exception error){
            System.out.println(error.getMessage());
            return "error";
        }

    }
//    @PostMapping("/register-doctor")
//    public ResponseEntity<String> registerDoctor(@RequestParam String email,
//                                                 @RequestParam String password,
//                                                 @RequestParam String firstName,
//                                                 @RequestParam String lastName,
//                                                 @RequestParam String position) {
//        // Создание пользователя
//        Users user = new Users();
//        usersService.save_doctor(user);
//
//        // Создание доктора
//        Doctor doctor = new Doctor();
//        doctor.setUser(user);
//        doctor.setFirstName(firstName);
//        doctor.setLastName(lastName);
//        doctor.setPosition(position);
//        doctorService.save(doctor); // Сохранение доктора
//
//        return new ResponseEntity<>("Doctor registered successfully", HttpStatus.CREATED);
//    }

//    @PostMapping("/register-doctor")
//    public ResponseEntity<String> registerDoctor(@RequestParam String email,
//                                                 @RequestParam String password,
//                                                 @RequestParam String firstName,
//                                                 @RequestParam String lastName,
//                                                 @RequestParam String position,
//                                                 @RequestParam Long specialtyId) {
//
//        // Создание пользователя
//        Users user = new Users();
//        // Настройка пользователя (возможно, вам нужно дописать этот блок)
//        user.setEmail(email);
//        user.setPassword(password);
//        usersService.save_doctor(user); // Предположим, что метод называется `saveDoctor`
//
//        // Создание доктора
//        Doctor doctor = new Doctor();
//        doctor.setUser(user);
//        doctor.setFirstName(firstName);
//        doctor.setLastName(lastName);
//        doctor.setPosition(position);
//
//        // Получение специальности по идентификатору
//        Specialty specialty = specialtyService.findById(specialtyId); // Вызываем метод findById из SpecialtyService
//        doctor.setSpecialty(specialty);
//
//        doctorService.save(doctor); // Сохранение доктора
//
//        return new ResponseEntity<>("Doctor registered successfully", HttpStatus.CREATED);
//    }
    @Transactional
    @PostMapping("/register-doctor")
    public ResponseEntity<String> registerDoctor(@ModelAttribute DoctorDTO doctorRequest) {
        // СОЗДАНИЯ ПОЛЬЗОВАТЕЛЯ
        Users user = new Users();

        user.setEmail(doctorRequest.getEmail());
        user.setPassword(doctorRequest.getPassword());
        usersService.saveDoctor(user);

        // СОЗДАНИЕ ДОКТОРА
        Doctor doctor = new Doctor();
        doctor.setUser(user);
        doctor.setFirstName(doctorRequest.getFirstName());
        doctor.setLastName(doctorRequest.getLastName());
        doctor.setPosition(doctorRequest.getPosition());


        Specialty specialty = specialtyService.findById(doctorRequest.getSpecialtyId());
        doctor.setSpecialty(specialty);

        doctorService.save(doctor);

        return new ResponseEntity<>("Doctor registered successfully", HttpStatus.CREATED);
    }




    // Получение списка всех врачей
    @GetMapping("/all")
    public String showAllDoctors(Model model) {
        List<Doctor> doctors = doctorService.getAllDoctors();
        model.addAttribute("doctors", doctors);
        return "doctor/list-of-doctors";
    }

}
