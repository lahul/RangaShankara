package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.User;

@RepositoryRestResource
public interface UserHib extends CrudRepository<User, String>{

	public List<User> findByEmailAndPassword(String email,String password);
	public List<User> findByEmail(String email);
	public List<User> findByToken(String token);
	public User findFirstByEmail(String email);
	public User save(User user);
	public User findByuserPkId(int userPkId);
	
	@Query(value="select user_pk_id from user where email=:email LIMIT 1",nativeQuery=true)
	public int finduserPkIdByEmail(@Param("email")String email);
}
