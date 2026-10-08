package repository;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // o Spring Data implementar a partir do nome do método
    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);

    List<User> findByNomeContainingIgnoreCase(String trecho);

    // quando o nome do método não basta, JPQL explícito
    @Query("select u from User u where u.email like concat('%', :dominio)")
    List<User> doDominio(String dominio);

}

