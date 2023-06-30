package com.brexson.jpahibernate.course;

import com.brexson.jpahibernate.course.Course;
import com.brexson.jpahibernate.course.jdbc.CourseJdbcRepository;
import com.brexson.jpahibernate.course.jpa.CourseJpaRepository;
import com.brexson.jpahibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//     command line runner is used to run custom logic at the start of a spring application
//    @Autowired
//    private CourseJdbcRepository repository;

//    @Autowired
//    private CourseJpaRepository repository;
    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
//      JpaRepository interface uses .save() instead of .insert() to insert into or update a database
        repository.save(new Course(1, "Learn AWS Jpa!", "in28minutes"));
        repository.save(new Course(2, "Learn Azure Jpa!", "in28minutes"));
        repository.save(new Course(3, "Learn DevOps Jpa!", "in28minutes"));
        repository.deleteById(3l);

        System.out.println(repository.findById(1l));
        System.out.println(repository.findById(2l));
    }
}
