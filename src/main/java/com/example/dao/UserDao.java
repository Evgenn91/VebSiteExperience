package com.example.dao;

import com.example.entity.User;

import java.util.List;

/**
 * опишет как мы можем работать с базой данных
 */

public interface UserDao {

    void save(User user);

    User getById(int id);

    void delete(int id);

    void update(User user);

    List<User> findAll();



}
