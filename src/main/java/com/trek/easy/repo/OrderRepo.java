package com.trek.easy.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trek.easy.model.Orders;

public interface OrderRepo extends JpaRepository<Orders, Integer>{

}
