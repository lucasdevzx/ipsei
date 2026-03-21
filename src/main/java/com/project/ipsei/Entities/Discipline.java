package com.project.ipsei.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_discipline")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Discipline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String name;
    private String code;
    private String description;
    private Integer workload;
    private boolean active;
    @Embedded
    private Audit audit;
}
