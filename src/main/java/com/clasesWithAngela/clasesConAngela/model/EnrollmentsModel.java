package com.clasesWithAngela.clasesConAngela.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "enrollments")
public class EnrollmentsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_student")
    private StudentModel student;

    @ManyToOne
    @JoinColumn(name = "id_curses")
    private CursesModel curses;

    private double note_student;
}
