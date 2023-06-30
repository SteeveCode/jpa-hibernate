package com.brexson.jpahibernate.course.springdatajpa;

import com.brexson.jpahibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {
}
