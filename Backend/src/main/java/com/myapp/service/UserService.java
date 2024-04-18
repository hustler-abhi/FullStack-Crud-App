package com.myapp.service;

import com.myapp.model.User;

import java.util.List;

public interface UserService {

    User Save(User user);

    User Update(User user);

    List<User> all();

    User getOne(Integer id);

    User delete(Integer id);
}
