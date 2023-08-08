package com.hiringandtracking.config;

import com.hiringandtracking.entity.VhitOfferedStudentMaster;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;

public class StudentDataProcessor implements ItemProcessor<VhitOfferedStudentMaster, VhitOfferedStudentMaster> {
    public static final Logger logger= LogManager.getLogger(StudentDataProcessor.class);


    @Override
    public VhitOfferedStudentMaster process(VhitOfferedStudentMaster studentMaster){
        VhitOfferedStudentMaster newStudentMaster = new VhitOfferedStudentMaster();
      try{
          if(studentMaster instanceof  VhitOfferedStudentMaster){
              newStudentMaster = studentMaster;
          }
      }catch (Exception ex){
          logger.info("Error: {}" , ex.getMessage());
      }
        return newStudentMaster;
    }
}
