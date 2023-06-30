package com.brexson.jpahibernate.course;

import com.brexson.jpahibernate.course.Course;
import com.brexson.jpahibernate.course.jdbc.CourseJdbcRepository;
import com.brexson.jpahibernate.course.jpa.CourseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    // command line runner is used to run custom logic at the start of a spring application
//    @Autowired
//    private CourseJdbcRepository repository;

    @Autowired
    private CourseJpaRepository repository;
    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Learn AWS Jpa!", "in28minutes"));
        repository.insert(new Course(2, "Learn Azure Jpa!", "in28minutes"));
        repository.insert(new Course(3, "Learn DevOps Jpa!", "in28minutes"));
        repository.deleteById(3);

        System.out.println(repository.findById(1));
        System.out.println(repository.findById(2));
    }
}
