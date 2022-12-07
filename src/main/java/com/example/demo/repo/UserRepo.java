package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.user;

@Repository //to add spring bean during scan
public interface UserRepo extends JpaRepository<user, Long> {

}
