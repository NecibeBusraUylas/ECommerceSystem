package eCommorceSystem;

import eCommorceSystem.business.abstracts.UserService;
import eCommorceSystem.business.concretes.AuthManager;
import eCommorceSystem.business.concretes.UserManager;
import eCommorceSystem.core.concretes.GoogleAuthServiceAdapter;
import eCommorceSystem.dataAccess.concretes.HibernateUserDao;
import eCommorceSystem.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		
		User busra=new User(3,"Büþra","Uylaþ","busra@gmail.com","12345");
		UserService userService = new UserManager(new HibernateUserDao(), new AuthManager(new HibernateUserDao()), new GoogleAuthServiceAdapter());
		
		userService.signUp(busra);
		
		userService.logIn(busra.getMail(), busra.getPassword());
	}
}