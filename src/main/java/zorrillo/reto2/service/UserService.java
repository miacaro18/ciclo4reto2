/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zorrillo.reto2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zorrillo.reto2.model.User;
import zorrillo.reto2.repository.UserRepository;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Miguel_Castro
 */
@Service
public class UserService {
    /**
     * Autowired
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * User getAll
     */
    public List<User> getAll(){
        return userRepository.getAll();
    }

    /**
     * User getId
     */
    public Optional<User> getUser(Integer id){
        return userRepository.getUser(id);
    }

    /**
     * Exitencia Email
     */
    public boolean existeEmail(String email){
        return userRepository.existeEmail(email);
    }

    /**
     * Autenticar Combinacion
     */
    public User autenticateUser(String email, String password){
        Optional<User> usuario = userRepository.autenticateUser(email, password);
        if (usuario.isEmpty()){
            return new User();
        } else{
            return usuario.get();
        }
    }

    /**
     * Registrar new
     */
    public User create(User user){
        if (user.getId() == null){
            return user;
        } else {
            Optional <User> e = userRepository.getUser(user.getId());
            if (e.isEmpty()){
                if (existeEmail(user.getEmail())== false){
                    return userRepository.create(user);
                } else {
                    return user;
                }
            } else{
                return user;
            }
        }
    }

    /**
     * Editar Update
     */
    public User update(User user){
        if (user.getId() != null){
            Optional<User> userDb = userRepository.getUser(user.getId());
            if (!userDb.isEmpty()){
                if(user.getIdentification() != null){
                    userDb.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null){
                    userDb.get().setName(user.getName());
                }
                if (user.getBirthtDay() != null){
                    userDb.get().setBirthtDay(user.getBirthtDay());
                }
                if (user.getMonthBirthtDay() != null) {
                    userDb.get().setMonthBirthtDay(user.getMonthBirthtDay());
                }
                if (user.getAddress() != null){
                    userDb.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null){
                    userDb.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null){
                    userDb.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null){
                    userDb.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null){
                    userDb.get().setZone(user.getZone());
                }
                userRepository.update(userDb.get());
                return userDb.get();
            } else {
                return user;
            }
        }else {
            return user;
        }
    }

    /**
     * Eliminar Delete
     */
    public boolean delete(int userId){
        Optional<User> usuario = userRepository.getUser(userId);
        if(usuario.isEmpty()){
            return false;
        } else{
            userRepository.delete(usuario.get());
            return true;
        }
    }
}
