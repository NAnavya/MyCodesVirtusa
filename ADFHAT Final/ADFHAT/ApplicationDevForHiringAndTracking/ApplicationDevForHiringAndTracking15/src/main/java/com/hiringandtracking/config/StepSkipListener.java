package com.hiringandtracking.config;

import com.hiringandtracking.entity.VhitOfferedStudentMaster;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.core.SkipListener;

public class StepSkipListener implements SkipListener<VhitOfferedStudentMaster, Number> {
    public static final Logger logger= LogManager.getLogger(StepSkipListener.class);

    @Override
    public void onSkipInRead(Throwable throwable) {
        logger.info(throwable.getMessage());
    }

    @Override
    public void onSkipInWrite(Number number, Throwable throwable) {
        logger.info( "{} skipped items: {}",throwable.getMessage() ,number);
    }

    @Override
    public void onSkipInProcess(VhitOfferedStudentMaster studentMaster, Throwable throwable) {
        logger.info("{} skipped in process: {} " ,throwable.getMessage() , studentMaster);
    }
}
