package com.domaine.base.services;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.domaine.base.dto.UserAccountDto;
import com.domaine.base.entity.UserAccountEntity;
import com.domaine.base.exceptions.UserAccountNotFoundException;
import com.domaine.base.repository.UserAccountRepository;

public class LoginServiceTest {

	private UserAccountService accountService ;
	private UserAccountRepository accountRepository ;
	
	@BeforeEach
	void init() {
		accountRepository = new UserAccountRepository() ;
		accountService = new UserAccountService() ;
	}
	
	@Test
	void loginOk() {
		
		UserAccountDto accountDto = new UserAccountDto();
		accountDto.setEmail("pis@gmail.com");
		accountDto.setPassword("azerty123");
		
		Optional<UserAccountDto> user = accountService.login(accountDto.getEmail(), accountDto.getPassword());
		
		Assertions.assertTrue(user.isPresent());
	}
	
	@Test
	void loginKO() {
		
		 String email = "lamine@gmail.com" ;
		 UserAccountNotFoundException entityNotFoundException = assertThrows(
				 UserAccountNotFoundException.class,
				  () -> accountService.login(email, "azerty123")
		  );
		 Assertions.assertEquals("User with " + email + " not exist", entityNotFoundException.getMessage());
	}
	
	
}
