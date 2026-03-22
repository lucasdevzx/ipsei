package com.project.ipsei.Services;

import com.project.ipsei.Model.StudentPerformance;
import com.project.ipsei.Repositories.StudentPerformanceRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentPerformanceServiceImpl implements StudentPerformanceService {

    private final StudentPerformanceRepository repository;

    public StudentPerformanceServiceImpl(StudentPerformanceRepository repository) {
        this.repository = repository;
    }

    @Override
    public StudentPerformance create(StudentPerformance performance) {

        return repository.save(performance);
    }
    @Override
    public Optional<StudentPerformance> findById(Long id) {
        return repository.findById(id);
    }
    @Override
    public List<StudentPerformance> listByScoreRank() {
        /*
         * TODO: Isso aqui vai causar má performance, a melhor maneira de fazer isso é através de uma query SQL
         *  pequise por @Query Java 17 Repository e vais entender melhor como fazer esse retorno.
         */
        List<StudentPerformance> rows = repository.findAll(Sort.by(Sort.Direction.DESC, "score"));
        int rank = 1;
        for (StudentPerformance row : rows) {
            row.setRank(rank++);
        }
        return rows;
    }
}
