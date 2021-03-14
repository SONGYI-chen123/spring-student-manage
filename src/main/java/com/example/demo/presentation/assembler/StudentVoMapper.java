package com.example.demo.presentation.assembler;

import com.example.demo.application.dto.StudentDto;
import com.example.demo.presentation.vo.CreateStudentCommand;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentVoMapper {
    StudentVoMapper Mapper = Mappers.getMapper(StudentVoMapper.class);

    StudentDto toCreateStudentDto(CreateStudentCommand command);
}
