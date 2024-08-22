package com.domaine.base.services;

import java.util.Optional;

import com.domaine.base.dto.UserAccountDto;
import com.domaine.base.entity.UserAccountEntity;
import com.domaine.base.exceptions.UserAccountNotFoundException;
import com.domaine.base.mappers.UserAccountMapper;
import com.domaine.base.repository.IUserAccountUserRepository;
import com.domaine.base.repository.UserAccountRepository;

public class UserAccountService implements IUserAccountService{

	private IUserAccountUserRepository accountUserRepository = new UserAccountRepository() ;
	@Override
	public Optional<UserAccountDto> login(String email, String password) {
		
		Optional<UserAccountEntity> userEntity = accountUserRepository.login(email, password) ;
		
		if (userEntity.isPresent()) {
			return Optional.of(UserAccountMapper.toUserAccountDto(userEntity.get()));
		}else {
			throw new UserAccountNotFoundException("User with "+ email + " does  not exist") ;
		}
	}

}
