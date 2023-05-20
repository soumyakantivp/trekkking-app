package com.trek.easy.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trek.easy.model.Users;

public interface UsersRepo extends JpaRepository<Users, Integer>{

}
