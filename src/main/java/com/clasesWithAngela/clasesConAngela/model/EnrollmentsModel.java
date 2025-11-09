package com.clasesWithAngela.clasesConAngela.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_student")
    @JsonBackReference("student-enrollments")
    private StudentModel student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curse")
    @JsonBackReference("curses-enrollments")
    private CursesModel curses;

    private double note_student;
}