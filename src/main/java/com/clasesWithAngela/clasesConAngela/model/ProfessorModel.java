package com.clasesWithAngela.clasesConAngela.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "professor")
public class ProfessorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int age;
    private int years_experience;
    private String subjects;

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)

    //Este seria el hijo, aca es donde se devuelve lo del Managed
    @JsonBackReference
    private Set<CursesModel> curses;
}