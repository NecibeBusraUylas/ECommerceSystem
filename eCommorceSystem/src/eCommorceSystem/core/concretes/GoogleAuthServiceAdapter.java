package eCommorceSystem.core.concretes;

import eCommorceSystem.core.abstracts.SignUpService;
import eCommorceSystem.entities.concretes.User;
import eCommorceSystem.googleAuthService.GoogleAuthManager;

public class GoogleAuthServiceAdapter implements SignUpService{
	
	@Override
	public void signUpToSystem(User user) {
		GoogleAuthManager googleAuthManager=new GoogleAuthManager();
		googleAuthManager.signUp(user);
	}
}