package com.project.ipsei.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Data
@RequiredArgsConstructor
public class Profile {
    @Id
    @UuidGenerator
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String firstName;
    private String lastName;
    @Embedded
    private Address address;
    @Embedded
    private Audit audit;

    @OneToOne(mappedBy = "profile")
    private User user;

}
