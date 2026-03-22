package com.project.ipsei.Repositories;

import com.project.ipsei.Entities.StudentPerformance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentPerformanceRepository extends JpaRepository<StudentPerformance, Long> {
}