package com.example.datasource.datasource.repository.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.datasource.datasource.model.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("SELECT u.name AS name,u.id AS id FROM User u WHERE u.name = ?1")
	List<Object> findAllActiveUsers(String name);
}
