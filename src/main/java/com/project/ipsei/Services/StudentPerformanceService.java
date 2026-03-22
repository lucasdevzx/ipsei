package com.project.ipsei.Services;

import com.project.ipsei.Model.StudentPerformance;
import com.project.ipsei.Repositories.StudentPerformanceRepository;

import java.util.List;
import java.util.Optional;

public interface StudentPerformanceService {

 
     StudentPerformance create(StudentPerformance performance);

     Optional<StudentPerformance> findById(Long id);

     List<StudentPerformance> listByScoreRank();
}
