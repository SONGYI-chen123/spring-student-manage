package com.example.demo.infrastructure.persistence.repository;

import com.example.demo.common.base.JpaAndQueryDslExecutor;
import com.example.demo.domain.student.entity.Parent;
import com.example.demo.domain.student.repository.ParentRepository;
import com.example.demo.infrastructure.persistence.entity.ParentPo;

import static com.example.demo.infrastructure.persistence.assembler.ParentDataMapper.mapper;

public interface JpaParentRepository extends ParentRepository,
        JpaAndQueryDslExecutor<ParentPo, String> {
    @Override
    default Parent add(Parent parent){
        ParentPo parentPo = mapper.toPo(parent);
        this.save(parentPo);
        return mapper.toDo(parentPo);
    }
}
