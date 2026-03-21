package com.project.ipsei.Model;

import com.project.ipsei.Enums.Difficulty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_question")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String statement;
    private String type;
    private Difficulty difficulty;
    private Integer points;
    private boolean active;
    LocalDateTime  createdAt;
}