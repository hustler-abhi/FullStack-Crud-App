package com.myapp.service;

import com.myapp.model.User;
import com.myapp.repository.UserRepo;
import lombok.RequiredArgsConstructor;

import org.hibernate.internal.build.AllowSysOut;
import org.modelmapper.ModelMapper;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    private  final ModelMapper modelMapper;

    @Override
    public User Save(User user) {
        if(Objects.nonNull(user)){
            return userRepo.save(user);
        }else{
            throw new NullPointerException("User is null");
        }
    }

    @Override
    public User Update(User user) {
        User newUser = userRepo.findById(user.getId()).orElseThrow(()->new NullPointerException("User Not Found"));
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        userRepo.save(newUser);
        System.out.println(newUser.toString());
        System.out.println((user.toString()));
        return newUser;
    }

    @Override
    public List<User> all() {
        List<User> users = userRepo.findAll();

        return users.size() >0 ?users:null;
    }

    @Override
    public User getOne(Integer id) {
        User newUser = userRepo.findById(id).orElseThrow(()->new NullPointerException("User Not Found"));
        return newUser;
    }

    @Override
    public User delete(Integer id) {
        User newUser = userRepo.findById(id).orElseThrow(()->new NullPointerException("User Not Found"));
        userRepo.delete(newUser);
        return newUser;
    }
}
