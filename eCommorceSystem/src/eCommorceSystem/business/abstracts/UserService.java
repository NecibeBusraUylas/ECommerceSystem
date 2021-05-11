package eCommorceSystem.business.abstracts;

import java.util.List;

import eCommorceSystem.entities.concretes.User;

public interface UserService {

	void signUp(User user);
	void delete(User user);
	void update(User user);
	void logIn(String email, String password);
	User getUser(int id);
	List<User> getAllUser();
}