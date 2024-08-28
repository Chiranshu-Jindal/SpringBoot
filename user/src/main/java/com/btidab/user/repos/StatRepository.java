package com.btidab.user.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.btidab.user.model.StatModel;

public interface StatRepository extends JpaRepository<StatModel, Long> {

}
