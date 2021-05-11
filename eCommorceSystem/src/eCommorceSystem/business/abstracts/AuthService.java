package eCommorceSystem.business.abstracts;

public interface AuthService {

	boolean isMailValid(String email);
	boolean isPasswordValid(String password);
	boolean isMailUsedBefore(String email);
}