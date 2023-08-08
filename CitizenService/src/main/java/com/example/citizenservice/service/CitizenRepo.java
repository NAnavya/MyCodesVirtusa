package com.example.citizenservice.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.citizenservice.entities.Citizen;

public interface CitizenRepo extends JpaRepository<Citizen,Integer> {
	public List<Citizen> findByVaccinationCenterId(int id);

}
