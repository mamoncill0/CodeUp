package com.clasesWithAngela.clasesConAngela.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "curses")
public class CursesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nameCurse;

    @ManyToOne
    //Aca decimos que es de muchos a uno y le especificas como se va a unir (JOIN) con la tabla professor
    //O sea como se une el Curses con Professor, que vendria siendo esto una foreign key
    @JoinColumn(name = "id_professor")
    private ProfessorModel professor;

    @OneToMany(mappedBy = "curses", cascade = CascadeType.ALL)
    private Set<EnrollmentsModel> enrollments;
}