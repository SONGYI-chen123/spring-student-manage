package com.example.demo.infrastructure.persistence.repository;

import com.example.demo.common.base.JpaAndQueryDslExecutor;
import com.example.demo.domain.student.entity.Course;
import com.example.demo.domain.student.repository.CourseRepository;
import com.example.demo.infrastructure.persistence.entity.CoursePo;

import static com.example.demo.infrastructure.persistence.assembler.CourseDataMapper.mapper;

public interface JpaCourseRepository extends CourseRepository,
        JpaAndQueryDslExecutor<CoursePo, String> {
    default void saveCourse(Course course) {
        this.save(mapper.toPo(course));
    }

}
