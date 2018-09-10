package com.demo.settlement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.settlement.entities.CycleConfig;

@Repository
public interface CycleConfigRepository extends JpaRepository<CycleConfig, Long> {
}
