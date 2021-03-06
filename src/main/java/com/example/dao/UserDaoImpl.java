package com.example.dao;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {
    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(User user) {
        String sql = "INSERT INTO user (name, email, age) VALUES (?,?,?)";
        jdbcTemplate.update(sql,user.getName(),user.getEmail(),user.getAge());
    }

    @Override
    public User getById(int id) {
        String sql = "SELECT * FROM user WHERE id=?";
        return jdbcTemplate.queryForObject(sql,new UserMapper(),id);
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM user WHERE id =?";
        jdbcTemplate.update(sql,id);

    }

    @Override
    public void update(User user) {
        String sql = "UPDATE user SET name = ?, email =?, age=? WHERE id = ?";
        jdbcTemplate.update(sql,user.getId(),user.getName(),user.getEmail(),user.getAge());

    }

    //тут описано как достать этот Bean
    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql,new UserMapper());
    }
}
