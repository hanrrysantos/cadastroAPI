package br.com.cadastroapi.projeto.services;

import br.com.cadastroapi.projeto.entities.User;
import br.com.cadastroapi.projeto.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> listAll(){
        return userRepository.findAll();
    }

    public User criarUser(User user){
        return userRepository.save(user);
    }

    public User editarUser(User user){
        User newUser = userRepository.findById(user.getId()).orElseThrow(() -> new RuntimeException("Object not Found"));
        updateData(newUser, user);
        return userRepository.save(newUser);
    }

    private void updateData(User newUser, User user) {
        newUser.setNome(user.getNome());
        newUser.setEmail(user.getEmail());
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }
}
