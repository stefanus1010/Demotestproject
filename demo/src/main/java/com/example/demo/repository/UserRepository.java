package com.example.demo.repository;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	List<User> findByCreatedAtBetween (ZonedDateTime from,ZonedDateTime to);
}
