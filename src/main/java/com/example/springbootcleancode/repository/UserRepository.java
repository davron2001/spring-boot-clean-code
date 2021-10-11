package com.example.springbootcleancode.repository;

import com.example.springbootcleancode.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userUser);

    boolean existsByUserName(String userName);

}
