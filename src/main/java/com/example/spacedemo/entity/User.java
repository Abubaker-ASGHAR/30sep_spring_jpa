package com.example.spacedemo.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String email;
    private int age;

    // Getters and setters
}