package com.example.demo.infrastructure.persistence.assembler;

import com.example.demo.domain.student.entity.Parent;
import com.example.demo.infrastructure.persistence.entity.ParentPo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ParentDataMapper {
    ParentDataMapper mapper = getMapper(ParentDataMapper.class);

    Parent toDo(ParentPo parentPo);

    ParentPo toPo(Parent parent);
}
