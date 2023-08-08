package com.hiringandtracking.services;

import com.hiringandtracking.config.ExcelUtilConfig;
import com.hiringandtracking.entity.VhitOfferedStudentMaster;
import com.hiringandtracking.repo.VhitOfferedStudentMasterRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


@Service
public class StudentService {



    public static final String TEMP_STORAGE = "C:/SM_Work/Application Dev for Hiring and Tracking/files/";
    @Autowired
    JobLauncher jobLauncher;
public static final Logger logger=LogManager.getLogger(StudentService.class);

    @Autowired
    Job job;

    @Autowired
    ExcelUtilConfig excelUtilConfig;

    @Autowired
    VhitOfferedStudentMasterRepo studentMasterRepo;

    public void insertStudentRecordFromExcel(MultipartFile file, String sheetName) {
        try {
            List<VhitOfferedStudentMaster> studentMasterList = excelUtilConfig.excelToStudentMaster(file, sheetName);
            studentMasterRepo.saveAll(studentMasterList);
        } catch (Exception e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    public void insertStudentRecordFromCsv(MultipartFile file, String sheetName){
        try {
            String originalFileName = file.getOriginalFilename();
            File fileToImport = new File(TEMP_STORAGE + originalFileName);
            file.transferTo(fileToImport);

            JobParameters jobParameters = new JobParametersBuilder()
                    .addString("fullPathFileName", TEMP_STORAGE + originalFileName)
                    .addLong("startAt", System.currentTimeMillis())
                    .toJobParameters();

            JobExecution execution = jobLauncher.run(job, jobParameters);

            if(execution.getExitStatus().getExitCode().equals(ExitStatus.COMPLETED)){
                Files.deleteIfExists(Paths.get(TEMP_STORAGE + originalFileName));
            }

        } catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException | JobParametersInvalidException | IOException e) {

           logger.info(e.getMessage());
        }
    }
}
