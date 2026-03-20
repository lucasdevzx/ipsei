package com.project.ipsei.Services;

import com.project.ipsei.Model.StudentPerformance;
import com.project.ipsei.Repositories.StudentPerformanceRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentPerformanceService {

    private final StudentPerformanceRepository repository;

    public StudentPerformanceService(StudentPerformanceRepository repository) {
        this.repository = repository;
    }

    public StudentPerformance create(StudentPerformance performance) {
        return repository.save(performance);
    }

    public Optional<StudentPerformance> findById(Long id) {
        return repository.findById(id);
    }

    public List<StudentPerformance> listByScoreRank() {
        List<StudentPerformance> rows = repository.findAll(Sort.by(Sort.Direction.DESC, "score"));
        int rank = 1;
        for (StudentPerformance row : rows) {
            row.setRank(rank++);
        }
        return rows;
    }
}
