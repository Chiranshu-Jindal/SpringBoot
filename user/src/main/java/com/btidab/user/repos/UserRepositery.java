package com.btidab.user.repos ;

import org.springframework.data.jpa.repository.JpaRepository;

import com.btidab.user.model.UserModel;

public interface UserRepositery extends JpaRepository<UserModel,Long>{

}
