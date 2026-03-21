package com.project.ipsei.Entities;

import com.project.ipsei.Enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.UuidGenerator;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@RequiredArgsConstructor
public class User {
    @Id
    @UuidGenerator
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String password;
    private String email;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private List<Role> roles;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id") // FK no banco
    private Profile profile;

    @Embedded
    private Audit audit;
}
