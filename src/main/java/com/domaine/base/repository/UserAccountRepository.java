package com.domaine.base.repository;

import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.domaine.base.config.HibernateUtil;
import com.domaine.base.entity.UserAccountEntity;


public class UserAccountRepository extends RepositoryImpl<UserAccountEntity> implements IUserAccountUserRepository{

	private Session session = HibernateUtil.getSessionFactory().openSession();
	
	@Override
	public Optional<UserAccountEntity> login(String email, String password) {
		
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<UserAccountEntity> cr = cb.createQuery(UserAccountEntity.class);
		Root<UserAccountEntity> user = cr.from(UserAccountEntity.class);
		
		//Predicate pour la clause where
		Predicate predicateEmail = cb.equal(user.get("email"), email);
		Predicate predicatePwd = cb.equal(user.get("password"), password);
		Predicate finalPredicate = cb.and(predicateEmail, predicatePwd);
		
		cr.select(user);
		cr.where(finalPredicate);
		try {
			return Optional.ofNullable(session.createQuery(cr).getSingleResult());
		} catch (Exception e) {
			return Optional.empty();
		}
	}

}
