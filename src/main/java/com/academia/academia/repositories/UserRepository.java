package com.academia.academia.repositories;

import com.academia.academia.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Integer> {

    UserDetails findByLogin(String login);

}
