package com.sourav.database.databasedemo.jdbc;

import com.sourav.database.databasedemo.entity.Person;
import com.sourav.database.databasedemo.entity.PersonRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJdbcDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //select * from person
    public List<Person> findAll() {
        return jdbcTemplate.query("SELECT * from Person", new PersonRowMapper());
    }

    public Person findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * from Person WHERE id=?",
                new BeanPropertyRowMapper<Person>(Person.class), new Integer[]{id});
    }

    public List<Person> findByName(String name) {
        return jdbcTemplate.query("SELECT * FROM person WHERE name=?",
                new BeanPropertyRowMapper<>(Person.class), new Object[]{name});
    }

    public List<Person> findByLocation(String location) {
        return jdbcTemplate.query("SELECT * FROM person WHERE location=?",
                new BeanPropertyRowMapper<>(Person.class), new Object[]{location});
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM person WHERE id=?", new Object[]{id});
    }

    public int insert(Person person) {
        return jdbcTemplate.update("insert into person (id,name,location,birth_date) values (?,?,?,?)",
                new Object[]{person.getId(), person.getName(), person.getLocation(),
                        new Timestamp(person.getBirthDate().getTime())});
    }

    public int update(Person person) {
        return jdbcTemplate.update(
                "update person set name=? , location=?, birth_date=? where id=?",
                new Object[]{
                        person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()), person.getId()
                }
        );
    }
}
