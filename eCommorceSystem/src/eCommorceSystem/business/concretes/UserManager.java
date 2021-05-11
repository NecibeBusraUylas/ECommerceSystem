package eCommorceSystem.business.concretes;

import java.util.List;

import eCommorceSystem.business.abstracts.AuthService;
import eCommorceSystem.business.abstracts.UserService;
import eCommorceSystem.core.abstracts.SignUpService;
import eCommorceSystem.dataAccess.abstracts.UserDao;
import eCommorceSystem.entities.concretes.User;

public class UserManager implements UserService{

	private UserDao userDao;
	private AuthService authService;
	private SignUpService signUpService;

    public UserManager(UserDao userDao, AuthService authService, SignUpService signUpService) {
		super();
		this.userDao = userDao;
		this.authService = authService;
		this.signUpService = signUpService;
	}

    @Override
	public void signUp(User user) {
    	if(user.getPassword().length()<6 && user.getFirstName().length()<2 && user.getLastName().length()<2) {
			System.out.println("Length of Password must be at least 6! Length of First name and Last name must be at least 2!");
			return;
		}
		
		if(authService.isMailUsedBefore(user.getMail())) {
			System.out.println("Email address: "+user.getMail() + "is already in use. Please enter another Email address.");
			return;
		}
	
		userDao.add(user);
		signUpService.signUpToSystem(user);
		System.out.println("User signed up succesfully. Email send to " + user.getMail());
		
		
	}
    
	@Override
	public void delete(User user) {
		userDao.delete(user);
	}

	@Override
	public void update(User user) {
		if(authService.isMailValid(user.getMail()) && authService.isPasswordValid(user.getPassword())){
            userDao.update(user);
            return;
        }
	}

	@Override
	public void logIn(String email, String password) {
		if(authService.isMailValid(email)){
            System.out.println("User logged in.");
        }
	}
	
	@Override
	public User getUser(int id) {
		 return userDao.getUser(id);
	}

	@Override
	public List<User> getAllUser() {
		 return userDao.getAllUser();
	}
}