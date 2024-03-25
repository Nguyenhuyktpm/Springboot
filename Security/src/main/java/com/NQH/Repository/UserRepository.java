package com.NQH.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.NQH.Entity.UserEntity;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
    UserEntity findByUsername(String username);
    UserEntity findByRole(String role);
    Optional<UserEntity> findById(Long Id);
}
