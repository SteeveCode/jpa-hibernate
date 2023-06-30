package com.brexson.jpahibernate.course.jdbc;

import com.brexson.jpahibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {
   @Autowired
    private JdbcTemplate jdbcTemplate;
    private static String INSERT_QUERY =
            """
                insert into course(id, name, author) 
                values(?,?,?);
            """;
    public void insert(Course course){
      jdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(),course.getAuthor());
    }
    private static String DELETE_QUERY =
            """
                delete from course where id = ?;
            """;
    public void deleteById(long id){
        jdbcTemplate.update(DELETE_QUERY, id);
    }
    private static String SELECT_QUERY =
            """
                select * from course where id = ?;
            """;
    public Course findById(long id){
        // ResultSet => Bean => RowMapper
        return jdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
    }
}
