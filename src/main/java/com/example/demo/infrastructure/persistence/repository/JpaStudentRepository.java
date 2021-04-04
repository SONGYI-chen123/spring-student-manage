package com.example.demo.infrastructure.persistence.repository;

import com.example.demo.common.base.JpaAndQueryDslExecutor;
import com.example.demo.domain.student.entity.Student;
import com.example.demo.domain.student.repository.StudentRepository;
import com.example.demo.infrastructure.persistence.entity.QStudentPo;
import com.example.demo.infrastructure.persistence.entity.StudentPo;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.QBean;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.demo.infrastructure.persistence.assembler.StudentDataMapper.mapper;

public interface JpaStudentRepository extends StudentRepository,
        JpaAndQueryDslExecutor<StudentPo, String> {
    default void saveStudent(Student student) {
        this.save(mapper.toPo(student));
    }

    default List<Student> findAllStudents() {
        QStudentPo studentPo = QStudentPo.studentPo;

        return getJpaQueryFactory().select(studentPo).from(studentPo).fetch().stream().map(mapper::toDo)
                .collect(Collectors.toList());
    }
}
