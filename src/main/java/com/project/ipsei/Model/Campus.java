package com.project.ipsei.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_campus")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Campus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String name;
    private String city;
    private String state;

    // Acredito ser melhor transformar Adress em entidade
    private String adress;

    private String phone;
    private boolean active;
    private LocalDateTime createdAt;
}