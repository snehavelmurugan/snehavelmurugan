package com.carleasingsystem.api.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.carleasingsystem.api.Config.ConfigConstants;
import com.carleasingsystem.api.Entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> 
{
    @Query(value = ConfigConstants.FIND_BY_USERNAME_QUERY, nativeQuery = true)
    Optional<User> findByUsername(String username);

    @Query(value = ConfigConstants.FIND_BY_EMAIL_QUERY, nativeQuery = true)
    Optional<User> findByemail(String email);
}