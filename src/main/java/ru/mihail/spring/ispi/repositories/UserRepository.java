package ru.mihail.spring.ispi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mihail.spring.ispi.models.Users;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByEmail(String email);
}
