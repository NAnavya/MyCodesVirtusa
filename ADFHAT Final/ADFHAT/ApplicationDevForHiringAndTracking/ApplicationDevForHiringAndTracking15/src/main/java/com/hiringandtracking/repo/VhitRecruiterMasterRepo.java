package com.hiringandtracking.repo;

import com.hiringandtracking.entity.VhitRecruiterMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VhitRecruiterMasterRepo extends JpaRepository<VhitRecruiterMaster, Long> {

    VhitRecruiterMaster findRecruiterByvrmEmployeeId(int employeeId);

}
