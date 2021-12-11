/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zorrillo.reto2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import zorrillo.reto2.model.User;
import zorrillo.reto2.service.UserService;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Miguel_Castro
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {
    /**
     * Autowired
     */
    @Autowired
    private UserService userService;

    /**
     * User getAll
     */
    @GetMapping("/all")
    public List<User> getAll(){
        return userService.getAll();
    }

    /**
     * User getId
     */
    @GetMapping("{id}")
    public Optional<User>getUser(@PathVariable("id") Integer id){
        return userService.getUser(id);
    }

    /**
     * Exitencia Email
     */
    @GetMapping("/emailexist/{email}")
    public boolean existeEmail(@PathVariable("email") String email){
        return userService.existeEmail(email);
    }

    /**
     * Autenticar Combinacion
     */
    @GetMapping("/{email}/{password}")
    public User autenticateUser(@PathVariable("email") String email, @PathVariable("password") String password){
        return userService.autenticateUser(email, password);
    }

    /**
     * Registrar new
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user){
        return userService.create(user);
    }

    /**
     * Editar Update
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user){
        return userService.update(user);
    }

    /**
     * Eliminar Delete
     */
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return userService.delete(id);
    }
}
