package com.jpaex.springbootjpaexample.repository;

import com.jpaex.springbootjpaexample.entity.CrudEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CrudEntityRepository extends JpaRepository<CrudEntity, String> {

    // Query 어노테이션을 넣어주면 JPA에서 커스텀 쿼리를 사용할 수 있음. 파라미터 앞에 : <- 붙이는 것으로 파라미터 지정 가능
    @Query(value = "select name, age from sample_table where name = :name", nativeQuery = true)
    List<CrudEntity> searchParamRepo(@Param("name") String name);
}
