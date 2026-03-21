package com.project.ipsei.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_lesson")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String title;
    private String description;
    private String type;
    private String contentUrl;
    private Integer durationMinutes;
    private Integer orderIndex;
    private boolean published;
}