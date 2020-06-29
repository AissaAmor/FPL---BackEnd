package spring.session.FPL.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.session.FPL.Entity.User;

@Repository("UserRepository")
public interface UserRepository extends JpaRepository<User, Integer> {

}