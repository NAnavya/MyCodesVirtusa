package com.hiringandtracking.config;


import com.hiringandtracking.entity.VhitOfferedStudentMaster;

import com.hiringandtracking.repo.VhitOfferedStudentMasterRepo;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentMasterItemWriter implements ItemWriter<VhitOfferedStudentMaster> {
    @Autowired
    VhitOfferedStudentMasterRepo studentRepo;
    @Override
    public void write(Chunk<? extends VhitOfferedStudentMaster> studentList) throws Exception {
        studentRepo.saveAll(studentList);
    }
}
