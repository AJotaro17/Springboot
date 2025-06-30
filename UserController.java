package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
  
import com.example.demo.modal.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserRepository userRepository;

    public UserController() {
    }
    
    @GetMapping("/users/{id}")
    public ResponseEntity<com.example.demo.modal.User> getUserId(@PathVariable("id") long id){
        Optional<com.example.demo.modal.User> userData = userRepository.findById(id);
        
        if(userData.isPresent()){
            return new ResponseEntity<>(userData.get(), HttpStatus.OK);
            
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    
}
@PostMapping("/user")
  public ResponseEntity<User> createUser(@RequestBody User user){
    try {
        User uu = new User(user.getLocation(),user.getProduct(),user.getQuantity(),user.getEmail(),user.getNumber());
        User _user= userRepository.save(uu);
        return new ResponseEntity<>(_user,HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
   
@PutMapping("/users/{id}")
public ResponseEntity<User> updateUsers (@PathVariable("id") long id,@RequestBody User user){
    Optional<User> userData = userRepository.findById(id);

    if (userData.isPresent()){
        User _user = userData.get();
        _user.setLocation(user.getLocation());
        _user.setProduct(user.getProduct());
        _user.setQuantity(user.getQuantity());
        _user.setEmail(user.getEmail());
        _user.setNumber(user.getNumber());
        return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);

    }else{
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

@DeleteMapping("/users/{id}")
public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") long id){
    try {
        userRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }
}    
}

