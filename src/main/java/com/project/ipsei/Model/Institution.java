package com.project.ipsei.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_institution")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String name;
    private String cnpj;
    private String type;
    private String email;
    private String phone;

    // Acredito ser melhor transformar Adress em entidade
    private String address;

    private boolean active;
    private LocalDateTime createdAt;
}