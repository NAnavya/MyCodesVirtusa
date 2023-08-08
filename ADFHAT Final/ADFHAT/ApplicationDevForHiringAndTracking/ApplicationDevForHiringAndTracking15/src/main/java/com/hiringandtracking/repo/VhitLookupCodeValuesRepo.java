package com.hiringandtracking.repo;


import com.hiringandtracking.entity.VhitLookupCodeValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VhitLookupCodeValuesRepo extends JpaRepository<VhitLookupCodeValues,Integer> {

}
