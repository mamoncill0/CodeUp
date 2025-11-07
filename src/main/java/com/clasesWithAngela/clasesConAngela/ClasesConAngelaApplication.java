package com.clasesWithAngela.clasesConAngela;

import com.clasesWithAngela.clasesConAngela.model.CursesModel;
import com.clasesWithAngela.clasesConAngela.model.EnrollmentsModel;
import com.clasesWithAngela.clasesConAngela.model.ProfessorModel;
import com.clasesWithAngela.clasesConAngela.model.StudentModel;
import com.clasesWithAngela.clasesConAngela.repository.CursesRepository;
import com.clasesWithAngela.clasesConAngela.repository.EnrollmentsRepository;
import com.clasesWithAngela.clasesConAngela.repository.ProfessorRepository;
import com.clasesWithAngela.clasesConAngela.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClasesConAngelaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClasesConAngelaApplication.class, args);
	}

    @Bean
    CommandLineRunner initData(StudentRepository studentRepo,
                               ProfessorRepository professorRepo,
                               CursesRepository courseRepo,
                               EnrollmentsRepository enrollmentRepo) {
        return args -> {
            ProfessorModel p1 = new ProfessorModel();
            p1.setName("Carlos Pérez");
            p1.setAge(45);
            p1.setYears_experience(10);
            p1.setSubjects("Matemáticas");
            professorRepo.save(p1);

            CursesModel c1 = new CursesModel();
            c1.setNameCurse("Álgebra I");
            c1.setProfessor(p1);
            courseRepo.save(c1);

            StudentModel s1 = new StudentModel();
            s1.setFirst_name("Ana");
            s1.setFirst_surname("Gómez");
            studentRepo.save(s1);

            EnrollmentsModel e1 = new EnrollmentsModel();
            e1.setStudent(s1);
            e1.setCurses(c1);
            e1.setNote_student(4.5);
            enrollmentRepo.save(e1);
        };
    }
}
