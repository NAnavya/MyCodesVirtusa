package com.hiringandtracking.repo;

import com.hiringandtracking.entity.VhitLookupCodes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VhitLookupCodesRepo extends JpaRepository<VhitLookupCodes,Integer> {

    VhitLookupCodes findLookUpBylookUpCode(String lookUpCode);
}
