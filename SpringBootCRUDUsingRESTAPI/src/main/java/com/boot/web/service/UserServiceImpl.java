package com.boot.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.web.dao.UserRepository;
import com.boot.web.model.TblUser;

@Service
public class UserServiceImpl {

	@Autowired
	private UserRepository userRepository;

	public TblUser addUser(TblUser tblUser) {
		return userRepository.save(tblUser);
	}

	public List<TblUser> getAllData(){
		List<TblUser> list= (List<TblUser>) userRepository.findAll();
		return list;
	}

	public TblUser getDataById(int id)
	{
       return userRepository.findById(id);
	}

	public void deleteDataById(int id)
	{
		userRepository.deleteById(id);
	}

	public TblUser updateDataById(int id,TblUser tblUser)
	{
		tblUser.setId(id);
    	return userRepository.save(tblUser);
	}
}
