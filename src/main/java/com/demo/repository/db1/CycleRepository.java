package com.demo.repository.db1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.db1.Cycle;

@Repository
public interface CycleRepository extends JpaRepository<Cycle, Long> {
}
