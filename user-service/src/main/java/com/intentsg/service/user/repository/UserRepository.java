package com.intentsg.service.user.repository;

import com.intentsg.service.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
