package com.kwakmunsu.JWT.repository;

import com.kwakmunsu.JWT.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
