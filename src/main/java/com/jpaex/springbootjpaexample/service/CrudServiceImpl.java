package com.jpaex.springbootjpaexample.service;

import com.jpaex.springbootjpaexample.entity.CrudEntity;
import com.jpaex.springbootjpaexample.repository.CrudEntityRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CrudServiceImpl implements CrudService{

    private final CrudEntityRepository repository;

    // EntityManager를 사용해 쿼리를 만들어 사용하는 방법이 있음
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<CrudEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public String searchParamMember(Long age) {
        List result = manager.createQuery("select name from sample_table where age > :age")
                .setParameter("age", age)
                .getResultList();
        return result.toString();
    }

    @Override
    public String searchParamRepoMember(String name) {
        return repository.searchParamRepo(name).toString();
    }

    @Override
    public String insertMember(String name, Long age) {
        if(repository.findById(name).isPresent()) {
            return "같은 이름이 있음";

        } else {
            CrudEntity entity = CrudEntity.builder()
                    .name(name)
                    .age(age)
                    .build();
            repository.save(entity);
            return "이름 : " + name + " 나이 : " + age;
        }
    }

    @Override
    public String updateMember(String name, Long age) {
        if(repository.findById(name).isEmpty()) {
            return "입력한 " + name + "이 존재하지 않습니다";
        } else {
            repository.save(CrudEntity.builder()
                    .name(name)
                    .age(age)
                    .build()
            );
            return name + "의 나이를 " + age + "로 변경함.";
        }
    }


    @Override
    public String deleteMember(String name) {
        if(repository.findById(name).isEmpty()) {
            return "없는 " + name + "입니다.";
        } else {
            repository.delete(CrudEntity.builder().name(name).build());
            return "삭제완료";
        }

    }
}
