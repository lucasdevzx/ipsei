package com.project.ipsei.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_subject")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(length = 100)
    private String description;
    private String area;
    private boolean isActive;

    @Embedded
    private Audit audit;
}
