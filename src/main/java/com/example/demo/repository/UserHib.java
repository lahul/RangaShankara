package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.User;

@RepositoryRestResource
public interface UserHib extends CrudRepository<User, String>{

	public List<User> findByEmailAndPassword(String email,String password);
	public List<User> findByEmail(String email);
	public List<User> findByToken(String token);
	public User findFirstByEmail(String email);
	public User save(User user);
}
