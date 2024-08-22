package com.domaine.base.services;

import java.util.Optional;

import com.domaine.base.dto.UserAccountDto;

public interface IUserAccountService {

	Optional<UserAccountDto> login(String email, String password) ;
}
