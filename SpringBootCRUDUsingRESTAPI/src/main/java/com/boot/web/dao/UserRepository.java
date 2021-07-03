package com.boot.web.dao;

import org.springframework.data.repository.CrudRepository;

import com.boot.web.model.TblUser;

public interface UserRepository extends CrudRepository<TblUser, Integer> {

	public TblUser findById(int id);
}
