package onlinefood.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import onlinefood.model.User;

public interface UserDao extends JpaRepository<User, Integer> {
	public User findByEmailIdAndPassword(String email,String password);

	public  User findByEmailId(String email);

}
