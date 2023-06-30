package com.brexson.jpahibernate.course.jpa;

import com.brexson.jpahibernate.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJpaRepository {
    @PersistenceContext // @PersistenceContext is a more specific type of @Autowired and is required in this case
    private EntityManager entityManager;
  // .merge() merges the mappings from your class to the databases
    public void insert(Course course){
        entityManager.merge(course);
    }
    public Course findById(long id){
       return  entityManager.find(Course.class, id);
    }
    public void deleteById(long id){
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }
}
