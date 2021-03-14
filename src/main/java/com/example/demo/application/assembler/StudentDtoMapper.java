package com.example.demo.application.assembler;

import com.example.demo.application.dto.StudentDto;
import com.example.demo.domain.student.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentDtoMapper {
    StudentDtoMapper Mapper = getMapper(StudentDtoMapper.class);

    Student toStudent(StudentDto dto);
}
