package br.com.cadastroapi.projeto.controllers;

import br.com.cadastroapi.projeto.entities.User;
import br.com.cadastroapi.projeto.repositories.UserRepository;
import br.com.cadastroapi.projeto.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list = userService.listAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping(value="/cadastrar")
    public ResponseEntity<User> criarUser(@RequestBody User user){
        User newUser = userService.criarUser(user);
        return ResponseEntity.status(201).body(newUser);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<User> editarUser(@RequestBody User user){
        User newUser = userService.editarUser(user);
        return ResponseEntity.ok().body(newUser);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUser (@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
