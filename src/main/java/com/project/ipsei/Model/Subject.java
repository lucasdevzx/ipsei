package com.project.ipsei.Model;

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

    private String name;
    private String description;
    private String area;
    private boolean active;
}
