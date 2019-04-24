package auction.demo.repository;

import org.springframework.data.repository.CrudRepository;

import auction.demo.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
