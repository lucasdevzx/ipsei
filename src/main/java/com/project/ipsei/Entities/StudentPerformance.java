package com.project.ipsei.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_student_performance")
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class StudentPerformance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String studentName;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "student_performance_courses",
            joinColumns = @JoinColumn(name = "student_performance_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses = new ArrayList<>();

    private String term;
    private Double score;
    private String reward;

    @Transient
    private Integer rank;

    @Embedded
    private Audit audit;
}