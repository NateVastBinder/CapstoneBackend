package com.Capstone.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Capstone.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	
@Query(value = "select * from user where email = ?1 && password=?2", nativeQuery=true)
public User signIn(String email, String password);


@Query(value = "select * from user where id = ?1", nativeQuery=true)
public User getUserById(Integer id);


@Query(value = "select * from user where email = ?1", nativeQuery = true)
public User getUserByEmail(String email);

}

