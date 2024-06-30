package com.MGS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MGS.models.MGSModel;

public interface MGSColaboradores extends JpaRepository<MGSModel, Integer> {

}
