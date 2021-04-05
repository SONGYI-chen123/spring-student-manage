package com.example.demo.infrastructure.persistence.repository;

import com.example.demo.common.base.JpaAndQueryDslExecutor;
import com.example.demo.domain.student.entity.Student;
import com.example.demo.domain.student.repository.StudentRepository;
import com.example.demo.infrastructure.persistence.entity.QStudentPo;
import com.example.demo.infrastructure.persistence.entity.StudentPo;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.QBean;
import com.querydsl.jpa.impl.JPAQuery;

import java.util.List;

import static com.example.demo.infrastructure.persistence.assembler.StudentDataMapper.mapper;

public interface JpaStudentRepository extends StudentRepository,
        JpaAndQueryDslExecutor<StudentPo, String> {
    default void saveStudent(Student student) {
        this.save(mapper.toPo(student));
    }

    default List<Student> findAllStudents() {
        QStudentPo studentPo = QStudentPo.studentPo;
        QBean<Student> bean = Projections.bean(Student.class,studentPo.name,studentPo.age);
        JPAQuery<Student> from = getJpaQueryFactory().select(bean).from(studentPo);

        return from.fetch();
    }
}
