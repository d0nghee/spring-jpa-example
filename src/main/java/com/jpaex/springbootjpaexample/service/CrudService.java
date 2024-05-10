package com.jpaex.springbootjpaexample.service;

import com.jpaex.springbootjpaexample.entity.CrudEntity;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CrudService {
    List<CrudEntity> findAll();
    String searchParamMember(Long age);

    String searchParamRepoMember(String name);

    String insertMember(String name, Long age);

    String updateMember(String name, Long age);

    String deleteMember(String name);
}
