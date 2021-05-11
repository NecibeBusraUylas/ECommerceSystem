package eCommorceSystem.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eCommorceSystem.business.abstracts.AuthService;
import eCommorceSystem.dataAccess.abstracts.UserDao;

public class AuthManager implements AuthService{

	private UserDao userDao;
	
	public AuthManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public boolean isMailValid(String email) {
		String regex="^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);

		return matcher.find();
	}

	@Override
	public boolean isPasswordValid(String password) {
		for(String pass: userDao.getAllPasswords()) {
			if(pass == password) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isMailUsedBefore(String email) {
		for(String mail: userDao.getAllEmails()) {
			if(mail == email) {
				return true;
			}
		}
		return false;
	}

}