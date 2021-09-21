package com.example.hafnessbanque.metier;

public interface SecurityService {
	 String findLoggedInUsername();

	    void autoLogin(String username, String password);

}
