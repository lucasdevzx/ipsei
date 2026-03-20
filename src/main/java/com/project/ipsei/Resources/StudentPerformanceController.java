package com.project.ipsei.Resources;

import com.project.ipsei.Model.StudentPerformance;
import com.project.ipsei.Services.StudentPerformanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/performance")
public class StudentPerformanceController {

    private final StudentPerformanceService service;

    public StudentPerformanceController(StudentPerformanceService service) {
        this.service = service;
    }

    @PostMapping("/students")
    public ResponseEntity<StudentPerformance> createStudentPerformance(@RequestBody StudentPerformance request) {
        if (request.getStudentName() == null || request.getScore() == null) {
            return ResponseEntity.badRequest().build();
        }
        StudentPerformance saved = service.create(request);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentPerformance>> listStudentPerformance() {
        return ResponseEntity.ok(service.listByScoreRank());
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentPerformance> getStudentPerformance(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
