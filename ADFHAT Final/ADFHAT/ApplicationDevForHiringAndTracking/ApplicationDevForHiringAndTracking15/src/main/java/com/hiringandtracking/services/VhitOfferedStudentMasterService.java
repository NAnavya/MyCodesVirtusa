package com.hiringandtracking.services;

import com.hiringandtracking.config.ExcelUtilConfig;
import com.hiringandtracking.config.StudentFieldSetMapper;
import com.hiringandtracking.dto.VhitOfferedStudentMasterDto;
import com.hiringandtracking.entity.VhitOfferedStudentMaster;
import com.hiringandtracking.enums.Branch;
import com.hiringandtracking.enums.Gender;
import com.hiringandtracking.exceptions.RecordNotFoundException;
import com.hiringandtracking.repo.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Service
public class VhitOfferedStudentMasterService {



    public static final String TEMP_STORAGE = "C:/Users/NALLAGORLAN/Downloads/ApplicationDevForHiring/ApplicationDevForHiringAndTracking/ApplicationDevForHiringAndTracking/files/";
  //  public static final String TEMP_STORAGE = "C://Users//NALLAGORLAN//Downloads//ApplicationDevForHiring//ApplicationDevForHiringAndTracking//ApplicationDevForHiringAndTrackingfiles";


    @Autowired
    Job job;
    @Autowired
    JobLauncher jobLauncher;
    @Autowired
    VhitOfferedStudentMasterRepo studentRepo;

    @Autowired
    ExcelUtilConfig excelUtilConfig;



    @Autowired
    VhitCollegeMasterRepo vhitCollegeMasterRepo;

    @Autowired
    VhitJobdetailsMasterRepo vhitJobdetailsMasterRepo;

    @Autowired
    VhitLookupCodesRepo vhitLookupCodesRepo;

    @Autowired
    VhitRecruiterMasterRepo vhitRecruiterMasterRepo;


    public static final Logger logger= LogManager.getLogger(VhitOfferedStudentMasterService.class);


    private static final String DATE_PATTERN ="dd-MM-yyyy";

    /*
     addStudent saves a student record in db
     @params  VhitOfferedStudentMasterDto
     @returns saved student record
    */

    public VhitOfferedStudentMaster addStudent(VhitOfferedStudentMasterDto studentRecordDto) throws ParseException {

        VhitOfferedStudentMaster studentRecord = new VhitOfferedStudentMaster();
        studentRecord.setVosFirstName(studentRecordDto.getVosFirstName());
        studentRecord.setVosLastName(studentRecordDto.getVosLastName());
        studentRecord.setVosCollegeMail(studentRecordDto.getVosCollegeMail());
        studentRecord.setVosPersonalMail(studentRecordDto.getVosPersonalMail());
        studentRecord.setVosAadhaarNo(studentRecordDto.getVosAadhaarNo());
        studentRecord.setVosGender(Gender.valueOf(studentRecordDto.getVosGender()));
        studentRecord.setVosBranch(Branch.valueOf(studentRecordDto.getVosBranch()));
        studentRecord.setVosDOB(
                new Date(new SimpleDateFormat(DATE_PATTERN)
                        .parse(studentRecordDto.getVosDOB()).getTime())
        );
        studentRecord.setVosMobileNo(studentRecordDto.getVosMobileNo());
        studentRecord.setVosOfferedDate(
                new Date(new SimpleDateFormat(DATE_PATTERN)
                        .parse(studentRecordDto.getVosOfferedDate()).getTime())
        );
        studentRecord.setVosFinancialYearOnboarding(studentRecordDto.getVosFinancialYearOnboarding());
        studentRecord.setVosHiredThrough(studentRecordDto.getVosHiredThrough());

        studentRecord.setVosCollegeMaster(vhitCollegeMasterRepo.findCollegeByvmcName(studentRecordDto.getCollegeName()));

        studentRecord.setVosDegreeLookupMaster(vhitLookupCodesRepo.findLookUpBylookUpCode(studentRecordDto.getDegreeLookUp()));

        studentRecord.setVosRecruiterMaster(vhitRecruiterMasterRepo.findRecruiterByvrmEmployeeId(studentRecordDto.getRecruiterId()));

        studentRecord.setVmcTechStackLookUpCode(vhitLookupCodesRepo.findLookUpBylookUpCode(studentRecordDto.getTechStack()));

        studentRecord.setVosJobDetails(vhitJobdetailsMasterRepo.findJobDetailsByvjmRoleName(studentRecordDto.getRoleName()));


        return studentRepo.save(studentRecord);
    }



    /*
     getAllStudentsRecords retrieves a student record from db in page
     @params  int pageNo,int pageSize
     @returns list of VhitOfferedStudentMaster
    */
    public List<VhitOfferedStudentMaster> getAllStudentsRecords(int pageNo,int pageSize) throws RecordNotFoundException {

        Pageable paging =PageRequest.of(pageNo,pageSize);

        Page<VhitOfferedStudentMaster> pages=  studentRepo.findAll( paging);
        if(pages.hasContent()){
            return pages.getContent();
        }else {
            throw new RecordNotFoundException("No records Available");
        }
    }


    /*
     getStudentRecord retrieves a student record from db
     @params Long id
     @returns a student record
     @throws RecordNotFoundException
    */
    public VhitOfferedStudentMaster getStudentRecord(Long id) throws RecordNotFoundException {
        Optional<VhitOfferedStudentMaster> optionalEntity =  studentRepo.findById(id);
        VhitOfferedStudentMaster ent;
        if (optionalEntity.isPresent()) {
            ent = optionalEntity.get();
        }
        else{
            throw new RecordNotFoundException("NO Record Existing With the Id : "+id);
        }
        return ent;
    }


    /*
      updateStudentRecord updates a student record from db
      @params Long id,VhitOfferedStudentMasterDto studentRecordDto
      @returns updated student record
      @throws RecordNotFoundException
    */
    public VhitOfferedStudentMaster updateStudentRecord(Long id, VhitOfferedStudentMasterDto studentRecordDto) throws ParseException, RecordNotFoundException {


        Optional<VhitOfferedStudentMaster> ent = studentRepo.findById(id);
        VhitOfferedStudentMaster studentRecord;
        if (ent.isPresent()) {
            studentRecord = ent.get();
        }
        else{
            throw new RecordNotFoundException("Record you are trying to edit doesn't exist please check");
        }

        studentRecord.setVosFirstName(studentRecordDto.getVosFirstName());
        studentRecord.setVosLastName(studentRecordDto.getVosLastName());
        studentRecord.setVosCollegeMail(studentRecordDto.getVosCollegeMail());
        studentRecord.setVosPersonalMail(studentRecordDto.getVosPersonalMail());
        studentRecord.setVosAadhaarNo(studentRecordDto.getVosAadhaarNo());
        studentRecord.setVosGender(Gender.valueOf(studentRecordDto.getVosGender()));
        studentRecord.setVosBranch(Branch.valueOf(studentRecordDto.getVosBranch()));
        studentRecord.setVosDOB(
                new Date(new SimpleDateFormat(DATE_PATTERN)
                        .parse(studentRecordDto.getVosDOB()).getTime())
        );
        studentRecord.setVosMobileNo(studentRecordDto.getVosMobileNo());
        studentRecord.setVosOfferedDate(
                new Date(new SimpleDateFormat(DATE_PATTERN)
                        .parse(studentRecordDto.getVosOfferedDate()).getTime())
        );
        studentRecord.setVosFinancialYearOnboarding(studentRecordDto.getVosFinancialYearOnboarding());
        studentRecord.setVosHiredThrough(studentRecordDto.getVosHiredThrough());

        studentRecord.setVosCollegeMaster(vhitCollegeMasterRepo.findCollegeByvmcName(studentRecordDto.getCollegeName()));

        studentRecord.setVosJobDetails(vhitJobdetailsMasterRepo.findJobDetailsByvjmRoleName(studentRecordDto.getRoleName()));

        return studentRepo.save(studentRecord);

    }


    /*
     deleteStudentRecord deletes a student record from db
     @params Long id
     @returns a string "Student Record Deleted"
     @throws RecordNotFoundException
    */
    public String deleteStudentRecord(Long id) throws RecordNotFoundException {

        Optional<VhitOfferedStudentMaster> ent = studentRepo.findById(id);
        if (ent.isPresent()) {
            studentRepo.deleteById(id);
            return "Student Record Deleted";
        }
        else{
            throw new RecordNotFoundException("Record you are trying to delete doesn't exist please check");
        }
    }


    public void insertStudentRecordFromExcel(MultipartFile file, String sheetName) {
        try {
            List<VhitOfferedStudentMaster> studentMasterList = excelUtilConfig.excelToStudentMaster(file, sheetName);
            studentRepo.saveAll(studentMasterList);
        } catch (Exception e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }
    public void insertStudentRecordFromCsv(MultipartFile file, String sheetName) {
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

        } catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException |
                 JobParametersInvalidException | IOException e) {

            logger.warn(e.getMessage());
        }
    }
    }


