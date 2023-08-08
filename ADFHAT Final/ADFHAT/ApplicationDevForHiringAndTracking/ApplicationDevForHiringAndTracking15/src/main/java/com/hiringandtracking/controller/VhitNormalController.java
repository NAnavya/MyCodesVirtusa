package com.hiringandtracking.controller;


import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hiringandtracking.dto.VhitOfferedStudentMasterDto;
import com.hiringandtracking.entity.VhitOfferedStudentMaster;
import com.hiringandtracking.exceptions.RecordNotFoundException;
import com.hiringandtracking.services.VhitOfferedStudentMasterService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/Vhit")

@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VhitNormalController {


    @Autowired
    VhitOfferedStudentMasterService studentService;

    @PostMapping("/addRecord")
    public ResponseEntity<VhitOfferedStudentMaster>  addRecords(@Valid @RequestBody VhitOfferedStudentMasterDto studentRecord) throws ParseException {

        return new ResponseEntity<>(studentService.addStudent(studentRecord),HttpStatus.CREATED);
    }

    @GetMapping("/getStudentRecords")
    public ResponseEntity<List<VhitOfferedStudentMaster>> getAllStudentRecords(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize
    ) throws RecordNotFoundException {
        List<VhitOfferedStudentMaster> list=studentService.getAllStudentsRecords(pageNo,pageSize);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/getStudentRecord/{id}")
    public ResponseEntity<VhitOfferedStudentMaster> getStudentRecord(@PathVariable long id) throws RecordNotFoundException {

        return new ResponseEntity<>(studentService.getStudentRecord(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VhitOfferedStudentMaster> updateStudentRecord(@PathVariable int id, @RequestBody VhitOfferedStudentMasterDto studentRecord) throws ParseException, RecordNotFoundException {

        return new ResponseEntity<>(studentService.updateStudentRecord((long) id, studentRecord), HttpStatus.OK);
    }

    @DeleteMapping("/deleteRecord/{id}")
    public ResponseEntity<String> deleteStudentRecord(@PathVariable int id) throws RecordNotFoundException {

        return new ResponseEntity<>(studentService.deleteStudentRecord((long) id), HttpStatus.OK);
    }


    @PostMapping(path="/upload/{fileType}/{sheetName}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadFile(@RequestParam("file") MultipartFile file,@PathVariable String fileType, @PathVariable String sheetName) {

        try {
            if(fileType.equals("CSV")){
                studentService.insertStudentRecordFromCsv(file, sheetName);
            }else{
                studentService.insertStudentRecordFromExcel(file, sheetName);
            }
            return "OK";
        }catch (Exception e){
            e.printStackTrace();
            return "ERROR";
        }

    }





}
