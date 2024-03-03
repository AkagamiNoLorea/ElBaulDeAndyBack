package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table (name = "characters")
public class MyCharacter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "img", nullable = false)
    private String img;
    @Column(name = "description", length = 1000)
    private String description;
}
