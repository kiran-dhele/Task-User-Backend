package com.neosoft.main.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.neosoft.main.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

	public List<User> findByName(String input);
	
	public List<User> findBySurname(String input);
	
	public List<User> findByPincode(String input);

	public User findById(int uid);
	
//	@Transactional
//	@Modifying
//	@Query(value = "from user where deleted=:flag")
//	public List<User> findAll(@Param("flag") String flag);
	
	@Query(value = "select * from user where deleted=:status", nativeQuery = true)
	public List<User> findAllByDeleted(@Param("status") String status);
	
	@Transactional
	@Modifying
	@Query(value = "update User set deleted=:status where id=:id", nativeQuery = true)
	public void saveById(@Param("id") int id, String status);
	
}
