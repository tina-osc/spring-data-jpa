package board.demo.repository;

import board.demo.dto.UserDto;
import board.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
