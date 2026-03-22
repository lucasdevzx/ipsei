package com.project.ipsei.Entities;

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



    private String phone;
    private boolean active;
    private LocalDateTime createdAt;
    @Embedded
    private Address address;
    @Embedded
    private Audit audit;
}