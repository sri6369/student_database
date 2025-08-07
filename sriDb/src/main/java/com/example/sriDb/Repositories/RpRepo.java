package com.example.sriDb.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sriDb.Entity.sData;

public interface RpRepo extends JpaRepository<sData, Integer> {

}
