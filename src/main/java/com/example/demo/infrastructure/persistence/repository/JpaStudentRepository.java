package com.example.demo.infrastructure.persistence.repository;

import com.example.demo.common.base.JpaAndQueryDslExecutor;
import com.example.demo.domain.student.entity.Student;
import com.example.demo.domain.student.repository.StudentRepository;
import com.example.demo.infrastructure.persistence.entity.QStudentPo;
import com.example.demo.infrastructure.persistence.entity.StudentPo;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;

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
        JPAQuery<Tuple> from = getJpaQueryFactory().select(studentPo.name, studentPo.age).from(studentPo);

        return from.fetch().stream().map(this::toStudent).collect(Collectors.toList());
    }

    default Student toStudent(Tuple tuple) {
        return Student.builder()
                .id(tuple.get(QStudentPo.studentPo.id))
                .age(tuple.get(QStudentPo.studentPo.age))
                .phoneNumber(tuple.get(QStudentPo.studentPo.phoneNumber))
                .gender(tuple.get(QStudentPo.studentPo.gender))
                .name(tuple.get(QStudentPo.studentPo.name))
                .build();
    }
}
