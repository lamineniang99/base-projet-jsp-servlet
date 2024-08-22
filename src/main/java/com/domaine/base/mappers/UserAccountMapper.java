package com.domaine.base.mappers;

import com.domaine.base.dto.UserAccountDto;
import com.domaine.base.entity.UserAccountEntity;

public class UserAccountMapper {

	public static UserAccountDto toUserAccountDto(UserAccountEntity accountEntity) {
		return new UserAccountDto(accountEntity.getEmail(), accountEntity.getPassword());
	}
}
