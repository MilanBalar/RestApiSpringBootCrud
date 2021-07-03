package com.boot.web.service;

import java.util.List;

import com.boot.web.model.TblUser;

public interface UserServices {

	public TblUser addUser(TblUser tblUser);

	public List<TblUser> getAllData();

	public TblUser getDataById(int id);

	public void deleteDataById(int id);

	public TblUser updateDataById(int id,TblUser tblUser);


}
