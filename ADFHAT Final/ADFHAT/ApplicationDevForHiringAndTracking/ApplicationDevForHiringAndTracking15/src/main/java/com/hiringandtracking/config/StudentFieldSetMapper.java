package com.hiringandtracking.config;


import com.hiringandtracking.entity.VhitOfferedStudentMaster;

import com.hiringandtracking.enums.Branch;
import com.hiringandtracking.enums.Gender;
import com.hiringandtracking.exceptions.RecordNotFoundException;
import com.hiringandtracking.repo.VhitOfferedStudentMasterRepo;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.text.ParseException;

public class StudentFieldSetMapper implements FieldSetMapper<VhitOfferedStudentMaster> {
    @Autowired
    VhitOfferedStudentMasterRepo studentMasterRepo;
    @Autowired
    FileParseErrorList errorList;
    @SneakyThrows
    @Override
    public VhitOfferedStudentMaster mapFieldSet(FieldSet fieldSet) throws BindException {
        VhitOfferedStudentMaster studentMaster = new VhitOfferedStudentMaster();
        List<String> skippedRecords = errorList.getErrorList();
        try {
            studentMaster.setVosFirstName(fieldSet.readString("First_Name"));
        }
        catch (NullPointerException e){
            skippedRecords.add("First Name is Null at");
        }
        catch (IllegalStateException e){
            skippedRecords.add("wrong Data entered at FirstName");
        }
        try {
            studentMaster.setVosLastName(fieldSet.readString("Last_Name"));
        }
        catch (NullPointerException e){

        }
        catch (IllegalStateException e){

        }        try {
            studentMaster.setVosCollegeMail(fieldSet.readString("College_Email"));
        }
        catch (NullPointerException e){

        }catch (IllegalStateException e){

        }
        try {
            studentMaster.setVosPersonalMail(fieldSet.readString("Personal_Email"));
        }catch (NullPointerException e){

        }catch (IllegalStateException e){

        }
        try {
            studentMaster.setVosAadhaarNo(fieldSet.readString("Aadhaar_No"));
        }catch (NullPointerException e){

        }catch (IllegalStateException e){

        }
        try {
            studentMaster.setVosMobileNo(fieldSet.readString("Mobile_No"));
        }
        catch (NullPointerException e){

        }catch (IllegalStateException e){

        }
        try {
            studentMaster.setVosGender(Gender.valueOf(fieldSet.readString("Gender").toUpperCase()));
        }
        catch (NullPointerException e){

        }catch (IllegalStateException e){

        }
        try {
            studentMaster.setVosBranch(Branch.valueOf(fieldSet.readString("Branch").toUpperCase()));
        }catch (NullPointerException e){

        }catch (IllegalStateException e){

        }
        try {
            studentMaster.setVosHiredThrough(fieldSet.readString("Hired_Through"));
        }catch (NullPointerException e){

        }catch (IllegalStateException e){

        }
        try {
            studentMaster.setVosDOB(new java.sql.Date(new SimpleDateFormat("dd/MM/yyyy")
                    .parse(fieldSet.readString("Date_Of_Birth"))
                    .getTime()));
        }catch (NullPointerException e){

        }catch (ParseException e){

        }
        catch (IllegalStateException e){

        }
        try {
            studentMaster.setVosOfferedDate(new java.sql.Date(new SimpleDateFormat("dd/MM/yyyy")
                    .parse(fieldSet.readString("Offered_Date"))
                    .getTime()));
        }
        catch (NullPointerException e){

        }catch (ParseException e){

        } catch (IllegalStateException e){

        }
        try {
            studentMaster.setVosFinancialYearOnboarding(fieldSet.readInt("Onboarding_Year"));
        }catch (NullPointerException e){
            skippedRecords.add("First Name is Null at");
        }catch (IllegalStateException e){
            skippedRecords.add("wrong Data entered at FirstName");
        }        studentMaster.setVosCollegeMaster(null);
        studentMaster.setVosDegreeLookupMaster(null);
        studentMaster.setVosRecruiterMaster(null);
        studentMaster.setVosJobDetails(null);
        long userId = this.getUserIdByAadharNo(studentMaster.getVosAadhaarNo());
        if(userId != -1){
            studentMaster.setVosId(userId);
        }
        System.out.println(studentMaster.toString());
        return studentMaster;
    }
    private long getUserIdByAadharNo(String aadharNo){
        long userId = -1;
        try{
            Optional<VhitOfferedStudentMaster> optionalStudent = studentMasterRepo.findStudentByvosAadhaarNo(aadharNo);
            if(optionalStudent.isEmpty()){
                throw new RuntimeException("User Not Present");
            }
            userId = optionalStudent.get().getVosId();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return userId;
    }
}