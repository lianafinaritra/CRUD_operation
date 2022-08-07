package com.source.yume.repository;

import com.source.yume.modele.Students;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository{

    List<Students> findAll();

    Students save(Students s);

    void deleteById(int Id);

    List<Students> findWhereNameLike(String query);

}