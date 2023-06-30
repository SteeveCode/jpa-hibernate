package com.brexson.jpahibernate.course.jdbc;

import com.brexson.jpahibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    // command line runner is used to run custom logic at the start of a spring application
    @Autowired
    private CourseJdbcRepository repository;
    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Learn AWS Now!", "in28minutes"));
        repository.insert(new Course(2, "Learn Azure Now!", "in28minutes"));
        repository.insert(new Course(3, "Learn DevOps Now!", "in28minutes"));
        repository.deleteById(3);
        System.out.println(repository.findById(1));
        System.out.println(repository.findById(2));

    }
}
