package com.boot.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.boot.web.model.TblUser;
import com.boot.web.service.UserServiceImpl;

@Controller
public class UserController {

	@Autowired
	UserServiceImpl userServices;

	@PostMapping("/add/users")
	public ResponseEntity<TblUser> add(@RequestBody TblUser tblUser) {
		try {
			tblUser = userServices.addUser(tblUser);
			if (tblUser == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.ok().body(tblUser);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping("/get/users/{id}")
	public ResponseEntity<TblUser> getDataById(@PathVariable("id") int id) {
		try {
			TblUser tblUser = userServices.getDataById(id);
			if (tblUser == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.ok().body(tblUser);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	@GetMapping("/getAll/users")
	public ResponseEntity<List<TblUser>> getAllData() {
		try {
			List<TblUser> list = userServices.getAllData();
			if (list.size()<=0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.ok().body(list);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	@DeleteMapping("/delete/users/{id}")
	public ResponseEntity<?> deleteDataById(@PathVariable("id") int id) {
		try {
			userServices.deleteDataById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
    }

	@PutMapping("/update/users/{id}")
	public ResponseEntity<?> UpdateBuId(@RequestBody TblUser tblUser,@PathVariable("id") int id) {

		try {
			TblUser user=userServices.updateDataById(id, tblUser);
			if(user==null) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
			return ResponseEntity.ok().body(user);
        } catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
    }
}
