package br.com.cadastroapi.projeto.repositories;

import br.com.cadastroapi.projeto.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
}
