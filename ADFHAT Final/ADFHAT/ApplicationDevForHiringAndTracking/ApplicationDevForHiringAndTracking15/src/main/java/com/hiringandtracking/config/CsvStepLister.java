package com.hiringandtracking.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.file.FlatFileParseException;

public class CsvStepLister implements StepExecutionListener {

    public static final Logger logger= LogManager.getLogger(CsvStepLister.class);

    @Override
    public void beforeStep(StepExecution stepExecution) {
        if (stepExecution.getFailureExceptions().size() > 0) {
            for (Throwable t : stepExecution.getFailureExceptions()) {
                if (t instanceof FlatFileParseException) {
                    FlatFileParseException parseException = (FlatFileParseException) t;
                    logger.info(" Before Reading, Error reading file at line {}     and input:{}   {}"  ,parseException.getLineNumber(),parseException.getInput(),parseException.getMessage());
                }
            }
        }
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        if (stepExecution.getFailureExceptions().size() > 0) {
            for (Throwable t : stepExecution.getFailureExceptions()) {
                if (t instanceof FlatFileParseException) {
                    FlatFileParseException parseException = (FlatFileParseException) t;
                    logger.info("After Reading, Error reading file at line {} and input: {}  {} ", parseException.getLineNumber(),parseException.getInput() , parseException.getMessage());
                }
            }
        }
        return stepExecution.getExitStatus();
    }
}