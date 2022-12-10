package com.parbatSubedi.springBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.parbatSubedi.springBoot.entity.Users;


public interface UserRepository extends JpaRepository<Users, Long> {
	

}
