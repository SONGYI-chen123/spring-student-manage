package com.example.demo.infrastructure.persistence.repository;

import com.example.demo.common.base.JpaAndQueryDslExecutor;
import com.example.demo.domain.student.entity.Course;
import com.example.demo.domain.student.entity.Student;
import com.example.demo.domain.student.repository.StudentRepository;
import com.example.demo.infrastructure.persistence.entity.QCoursePo;
import com.example.demo.infrastructure.persistence.entity.QStudentPo;
import com.example.demo.infrastructure.persistence.entity.StudentPo;
import com.querydsl.core.group.GroupBy;
import com.querydsl.core.types.Projections;
import java.util.Map;

import static com.example.demo.infrastructure.persistence.assembler.StudentDataMapper.mapper;

public interface JpaStudentRepository extends StudentRepository,
        JpaAndQueryDslExecutor<StudentPo, String> {
    default Student add(Student student) {
        StudentPo studentPo = mapper.toPo(student);
        this.save(studentPo);
        return mapper.toDo(studentPo);
    }

    default Map<String,Student> findAllStudents() {
        QStudentPo studentPo = QStudentPo.studentPo;
        QCoursePo coursePo = QCoursePo.coursePo;
        Map<String,Student> studentMap = getJpaQueryFactory().from(studentPo)
                .leftJoin(coursePo)
                .on(studentPo.id.eq(coursePo.studentId))
                .orderBy(studentPo.name.asc())
                .transform(GroupBy.groupBy(studentPo.id).as(Projections.bean(Student.class,
                        studentPo.name,
                        GroupBy.list(Projections.bean(Course.class,
                                coursePo.name
                        )).as("courses")
                )));
        return studentMap;
    }
}
