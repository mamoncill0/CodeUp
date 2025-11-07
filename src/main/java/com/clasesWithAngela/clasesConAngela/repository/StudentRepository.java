package com.clasesWithAngela.clasesConAngela.repository;

import com.clasesWithAngela.clasesConAngela.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentModel, Long> {

}

