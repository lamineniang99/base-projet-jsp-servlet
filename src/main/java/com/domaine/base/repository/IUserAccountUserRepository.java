package com.domaine.base.repository;

import java.util.Optional;

import com.domaine.base.entity.UserAccountEntity;

public interface IUserAccountUserRepository  extends Repository<UserAccountEntity>{

	Optional<UserAccountEntity> login(String email, String password) ;
}
