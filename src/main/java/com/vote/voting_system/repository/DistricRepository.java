package com.vote.voting_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vote.voting_system.Model.District;

public interface DistricRepository extends JpaRepository<District, Integer> {

}
