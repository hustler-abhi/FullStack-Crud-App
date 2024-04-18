package com.myapp.controller;

import com.myapp.model.User;
import com.myapp.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    private  final UserService userService;

    @PostMapping
    public ResponseEntity<User> Save(@RequestBody @Valid User user) {
        return new ResponseEntity<>(userService.Save(user), HttpStatusCode.valueOf(201));
    }


    @PutMapping
    public ResponseEntity<User> Update(@RequestBody @Valid User user) {

        return ResponseEntity.ok(userService.Update(user));
    }


    @GetMapping
    public ResponseEntity<List<User>> all() {
        return ResponseEntity.ok(userService.all());
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> getOne(@PathVariable Integer id) {

        return ResponseEntity.ok(userService.getOne(id));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable Integer id) {

        return ResponseEntity.ok(userService.delete(id));
    }
}
