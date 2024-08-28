package com.btidab.user.repos ;

import org.springframework.data.jpa.repository.JpaRepository;

import com.btidab.user.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel,Long>{

}
