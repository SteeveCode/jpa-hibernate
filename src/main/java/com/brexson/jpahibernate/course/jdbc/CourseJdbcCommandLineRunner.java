package com.brexson.jpahibernate.course.jdbc;

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
        repository.insert();
    }
}
