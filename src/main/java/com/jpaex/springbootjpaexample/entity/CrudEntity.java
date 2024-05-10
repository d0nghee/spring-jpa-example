package com.jpaex.springbootjpaexample.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "sample_table")
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CrudEntity {

    @Id
    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Long age;
}
