package com.clasesWithAngela.clasesConAngela.controller;

import com.clasesWithAngela.clasesConAngela.model.CursesModel;
import com.clasesWithAngela.clasesConAngela.model.EnrollmentsModel;
import com.clasesWithAngela.clasesConAngela.model.StudentModel;
import com.clasesWithAngela.clasesConAngela.repository.CursesRepository;
import com.clasesWithAngela.clasesConAngela.repository.EnrollmentsRepository;
import com.clasesWithAngela.clasesConAngela.repository.ProfessorRepository;
import com.clasesWithAngela.clasesConAngela.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class ApiController {
    private final StudentRepository studentRepo;
    private final CursesRepository cursesRepo;
    private final ProfessorRepository professorRepo;
    private final EnrollmentsRepository enrollmentRepo;

    public ApiController(StudentRepository studentRepo, CursesRepository cursesRepo,
                         ProfessorRepository professorRepo, EnrollmentsRepository enrollmentRepo) {
        this.studentRepo = studentRepo;
        this.cursesRepo = cursesRepo;
        this.professorRepo = professorRepo;
        this.enrollmentRepo = enrollmentRepo;
    }

    @GetMapping("/students")
    public List<StudentModel> allStudents() {
        return studentRepo.findAll();
    }

    @GetMapping("/courses")
    public List<CursesModel> allCourses() {
        return cursesRepo.findAll();
    }

    @GetMapping("/enrollments")
    public List<EnrollmentsModel> allEnrollments() {
        return enrollmentRepo.findAll();
    }
}
