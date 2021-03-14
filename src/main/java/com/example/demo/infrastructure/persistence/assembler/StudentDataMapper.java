package com.example.demo.infrastructure.persistence.assembler;

import com.example.demo.infrastructure.persistence.entity.StudentPo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import com.example.demo.domain.student.entity.Student;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentDataMapper {
    StudentDataMapper mapper = getMapper(StudentDataMapper.class);

    StudentPo toPo(Student studnet);

    Student toDo(StudentPo studentPo);
}
