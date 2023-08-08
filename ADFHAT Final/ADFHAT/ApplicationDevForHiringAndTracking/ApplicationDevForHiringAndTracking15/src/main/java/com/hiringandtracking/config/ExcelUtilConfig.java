package com.hiringandtracking.config;



import java.io.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import com.hiringandtracking.entity.VhitOfferedStudentMaster;
import com.hiringandtracking.enums.Branch;
import com.hiringandtracking.enums.Gender;
import com.hiringandtracking.exceptions.RecordNotFoundException;
import com.hiringandtracking.repo.VhitOfferedStudentMasterRepo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

@Configuration
public class ExcelUtilConfig {
    @Autowired
    FileParseErrorList errorList;
    public final String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    private String[] HEADERs = {"SL.NO.","First_Name",
            "Last_Name","College_Email",
            "Personal_Email","Aadhaar_No",
            "Gender","Branch",
            "Date_Of_Birth", "Mobile_No",
            "Offered_Date","Onboarding_Year",
            "Hired_Through","College_Name",
            "Degeree","Recruiter_Name",
            "Job_Details"
    };

    //    private final String SHEET = "Sheet1";
   @Autowired
   VhitOfferedStudentMasterRepo studentMasterRepo;
  public boolean hasExcelFormat(MultipartFile file) {
      if (!TYPE.equals(file.getContentType())) {
          return false;
      }
      return true;
  }
  public List<VhitOfferedStudentMaster> excelToStudentMaster(MultipartFile file, String sheetName)
          throws IOException {
      if(!hasExcelFormat(file)){
          throw new IOException("File is Not in Proper Format");
      }
      InputStream stream = file.getInputStream();
      Workbook workbook = new XSSFWorkbook(stream);
      Sheet sheet = workbook.getSheet(sheetName);
      List<VhitOfferedStudentMaster> studentMasterList = new ArrayList<>();
      if(sheet == null){
          throw new IOException("Sheet is Null");
      }else{
          int rowNumber = 0;
          for (Row currentRow : sheet) {
              // skip header
               if (rowNumber == 0) {
                   rowNumber++;
                   continue;
               }
               Iterator<Cell> cellsInRow = currentRow.iterator();
              VhitOfferedStudentMaster studentEntity = new VhitOfferedStudentMaster();
               List<String> skippedRecords = errorList.getErrorList();
               int cellIdx = 0;
               boolean flag = true;
               while (cellsInRow.hasNext()) {
                   Cell currentCell = cellsInRow.next();
                   switch (cellIdx) {
                       case 0:
                           break;
                           case 1:

                               try {
                                   studentEntity.setVosFirstName(currentCell.getStringCellValue());
                                   }
                               catch (NullPointerException e){
                                   skippedRecords.add("First Name is Null at" + rowNumber);
                                   }
                               catch (IllegalStateException e){
                                   skippedRecords.add("wrong Data entered at FirstName" + rowNumber);
                               }
                               break;
                               case 2:
                                   try {
                                       studentEntity.setVosLastName(currentCell.getStringCellValue());
                                   }catch (NullPointerException e){

                                   }catch (IllegalStateException e){

                                   }
                                   break;
                                   case 3:
                                       try {
                                           studentEntity.setVosCollegeMail(currentCell.getStringCellValue());
                                       }catch (NullPointerException e){

                                       }
                                       catch (IllegalStateException e){

                                       }
                                       break;
                                       case 4:
                                           try {
                                               studentEntity.setVosPersonalMail(currentCell.getStringCellValue());
                                           }
                                           catch (NullPointerException e){

                                           }catch (IllegalStateException e){

                                           }
                                           break;
                                           case 5:
                                               try {
                                                   if (currentCell.getCellType() == CellType.STRING) {
                                                       if (currentCell.getStringCellValue().contains("E")) {
                                                           studentEntity.setVosAadhaarNo(String.format("%.0f", Double.parseDouble(currentCell.getStringCellValue())));
                                                       }
                                                       studentEntity.setVosAadhaarNo(currentCell.getStringCellValue());
                                                       }
                                                   else {
                                                       studentEntity.setVosAadhaarNo(String.format("%.0f", currentCell.getNumericCellValue()));
                                                        }
                                                   }
                                               catch (NullPointerException e){

                                               }
                                               catch (IllegalStateException e){

                                               }
                                               break;
                                               case 6:
                                                   try{
                                                       studentEntity.setVosGender(Gender.valueOf(currentCell.getStringCellValue().toUpperCase()));
                                                   }
                                                   catch (NullPointerException e){
                                                   }
                                                   catch (IllegalStateException e){
                                                   }
                                                   break;
                                                   case 7:
                                                       try{
                                                           studentEntity.setVosBranch(Branch.valueOf(currentCell.getStringCellValue().toUpperCase()));
                                                       }
                                                       catch (NullPointerException e){
                                                       }catch (IllegalStateException e){
                                                       }
                                                       break;
                                                       case 8:
                                                           try{
                                                               SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                                                               java.util.Date date = dateFormat.parse(currentCell.getStringCellValue());
                                                               Date sqlDate = new Date(date.getTime());
                                                               studentEntity.setVosDOB(sqlDate);
                                                           }
                                                           catch (ParseException e){

                                                           }
                                                           catch (NullPointerException e){

                                                           }catch (IllegalStateException e){

                                                           }
                                                           break;
                                                           case 9:
                                                               if (currentCell.getCellType() == CellType.STRING) {
                                                                   studentEntity.setVosMobileNo(currentCell.getStringCellValue());
                                                               } else {
                                                                   studentEntity.setVosMobileNo(String.format("%.0f", currentCell.getNumericCellValue()));
                                                               }
                                                               break;
                                                               case 10:
                                                                   try{
                                                                       SimpleDateFormat  dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                                                                       java.util.Date date = dateFormat.parse(currentCell.getStringCellValue());
                                                                       Date sqlDate = new Date(date.getTime());
                                                                       studentEntity.setVosOfferedDate(sqlDate);
                                                                   }
                                                                   catch (ParseException e){

                                                                   } catch (NullPointerException e){

                                                                   }catch (IllegalStateException e){

                                                                   }
                                                                   break;
                                                                   case 11:
                                                                       try{
                                                                           if (currentCell.getCellType() == CellType.STRING) {
                                                                               studentEntity.setVosFinancialYearOnboarding(Integer.parseInt(currentCell.getStringCellValue()));
                                                                           } else {
                                                                               studentEntity.setVosFinancialYearOnboarding((int) currentCell.getNumericCellValue());
                                                                           }
                                                                       }
                                                                       catch (NullPointerException e){

                                                                       }
                                                                       catch (IllegalStateException e){

                                                                       }
                                                                       break;
                                                                       case 12:
                                                                           try{
                                                                               studentEntity.setVosHiredThrough(currentCell.getStringCellValue());
                                                                           }

                                                                           catch (NullPointerException e){

                                                                           }
                                                                           catch (IllegalStateException e){

                                                                           }
                                                                           break;
                                                                           case 13:
                                                                               String collegeName = currentCell.getStringCellValue();
                                                                               System.out.println(collegeName);
                                                                               // do mapping with College_Master
                                                                             break;
                                                                             case 14:
                                                                                 String lookupCodeName = currentCell.getStringCellValue();
                                                                                 System.out.println(lookupCodeName);
                                                                                 // do mapping with Lookup_Code_Master
                                                                                 break;
                                                                                 case 15:
                                                                                     String recruiterName = currentCell.getStringCellValue();
                                                                                     System.out.println(recruiterName);
                                                                                     // do mapping with Recruiter_Master
                                                                                    break;
                                                                                    case 16:
                                                                                        String jobName = currentCell.getStringCellValue();
                                                                                        System.out.println(jobName); // do mapping with JobDetails_Master
                                                                                        break;
                                                                                        default:
                                                                                            break;
                   }
                   cellIdx++;
               }
               if (flag) {
                   System.out.println(studentEntity.toString());
                   long userId = this.getUserIdByAadharNo(studentEntity.getVosAadhaarNo());
                   if (userId != -1) {
                       studentEntity.setVosId(userId);
                   }
                   studentMasterList.add(studentEntity);
               }
          }
      }
      return studentMasterList;
  }
  private long getUserIdByAadharNo(String aadharNo){
      long userId = -1;
      try{
          Optional<VhitOfferedStudentMaster> optionalStudent = studentMasterRepo.findStudentByvosAadhaarNo(aadharNo);
          if(optionalStudent.isEmpty()){
              throw new RuntimeException("User Not Present");
          }
          userId = optionalStudent.get().getVosId();
      }
      catch (RuntimeException e) {
          System.out.println(e.getMessage());
      }
      return userId;
  }
}


