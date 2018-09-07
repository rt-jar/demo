package com.demo.repository.db1;

import com.demo.entity.db1.CycleConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CycleConfigRepository extends JpaRepository<CycleConfig, Long> {
}
