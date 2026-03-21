package com.project.ipsei.Entities;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "student_performance_courses",
            joinColumns = @JoinColumn(name = "student_performance_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses = new ArrayList<>();
    /**
     * Este campo é referente ao campo term de {@link AcademicTerm}?
     */
    private String term;
    private Double score;
    /**
     * Isto aqui deve ser uma entidade.
     * TODO: Criar entidae Reward
     */
    private String reward;
    /**
     * Isso aqui também deve ser uma entidade, UserRank
     * Pois devemos guardar o rank, de onde vem o Ranqueamento, até quando, quem ultrapassor, etc..
     * TODO: Criar entidade de ranquamento UserRank
     */
    @Transient
    private Integer rank;

    @Embedded
    private Audit audit;
}