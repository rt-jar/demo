package com.demo.settlement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.settlement.entities.Cycle;

@Repository
public interface CycleRepository extends JpaRepository<Cycle, Long> {
}
