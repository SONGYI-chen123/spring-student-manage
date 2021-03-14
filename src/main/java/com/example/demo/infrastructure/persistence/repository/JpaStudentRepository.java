package com.example.demo.infrastructure.persistence.repository;

import com.example.demo.common.base.JpaAndQueryDslExecutor;
import com.example.demo.domain.student.entity.Student;
import com.example.demo.domain.student.repository.StudentRepository;
import com.example.demo.infrastructure.persistence.entity.StudentPo;
import static com.example.demo.infrastructure.persistence.assembler.StudentDataMapper.mapper;

public interface JpaStudentRepository extends StudentRepository,
        JpaAndQueryDslExecutor<StudentPo, String> {
    default void saveStudent(Student student) {
        this.save(mapper.toPo(student));
    }
}
