package com.ad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ad.model.User;
import com.ad.service.ProductService;
import com.ad.utils.ProductConstants;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = ProductConstants.GET_USER_BY_NAME, method = RequestMethod.GET, headers = "Accept=application/json", produces = {
			"application/json" })
	public User getUserByName(@PathVariable String userName) throws Exception {
		System.out.println("ctrl");
		return productService.getUserByName(userName);
	}

	@RequestMapping(value = ProductConstants.GET_ALL_USERS, method = RequestMethod.GET, headers = "Accept=application/json", produces = {
			"application/json" })
	public List<User> getAllUsers() throws Exception {
		return productService.getAllUsers();
	}

	@RequestMapping(value = ProductConstants.SAVE_USER, method = RequestMethod.POST, headers = "Accept=application/json", produces = {
			"application/json" })
	public String saveUser(@PathVariable String userName, @RequestBody User user) throws Exception {
		return productService.saveUser(user);
	}

	@RequestMapping(value = ProductConstants.UPDATE_USER, method = RequestMethod.POST, headers = "Accept=application/json", produces = {
			"application/json" })
	public User updateUser(@PathVariable String userName, @RequestBody User user) throws Exception {
		return productService.updateUser(user);
	}
}
