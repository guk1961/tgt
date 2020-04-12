package ru.ourloc.tgtaxi.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.ourloc.tgtaxi.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByActivationCode(String code);
}
