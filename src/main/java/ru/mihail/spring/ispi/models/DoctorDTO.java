package ru.mihail.spring.ispi.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorDTO {
        private String email;
        private String password;
        private String firstName;
        private String lastName;
        private Long specialtyId; // Идентификатор специальности
        private String position;
}
