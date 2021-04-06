package com.example.demo.infrastructure.persistence.assembler;

import com.example.demo.domain.student.entity.Course;
import com.example.demo.infrastructure.persistence.entity.CoursePo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CourseDataMapper {
    CourseDataMapper mapper = getMapper(CourseDataMapper.class);

    CoursePo toPo(Course course);

    Course toDo(CoursePo coursePo);
}
