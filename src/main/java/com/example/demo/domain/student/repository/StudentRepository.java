package com.example.demo.domain.student.repository;

import com.example.demo.domain.student.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, String> {
}
