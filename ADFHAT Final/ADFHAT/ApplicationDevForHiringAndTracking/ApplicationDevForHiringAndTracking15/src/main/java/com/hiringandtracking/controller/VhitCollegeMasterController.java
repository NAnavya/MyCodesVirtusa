package com.hiringandtracking.controller;

import com.hiringandtracking.dto.VhitCollegeMasterDto;
import com.hiringandtracking.entity.VhitCollegeMaster;
import com.hiringandtracking.exceptions.RecordNotFoundException;
import com.hiringandtracking.services.VhitCollegeMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/Vhit")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VhitCollegeMasterController {

    @Autowired
    VhitCollegeMasterService vhitCollegeMasterService;

    @PostMapping("/addCollege")
    public ResponseEntity<VhitCollegeMaster> addCollege(@RequestBody VhitCollegeMasterDto collegeDetails) throws ParseException {

        return new ResponseEntity<>(vhitCollegeMasterService.addCollege(collegeDetails), HttpStatus.CREATED);

    }

    @PutMapping("/updateCollege/{id}")
    public ResponseEntity<VhitCollegeMaster> updateCollege(@PathVariable int id,@RequestBody VhitCollegeMasterDto vhitCollegeMasterDto) throws RecordNotFoundException, ParseException {

        return new ResponseEntity<>(vhitCollegeMasterService.updateCollege(id, vhitCollegeMasterDto), HttpStatus.OK);
    }

    @GetMapping("/getAllColleges")
    public ResponseEntity<List<VhitCollegeMaster>> getAllColleges(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize
    ) throws RecordNotFoundException {

        return new ResponseEntity<>(vhitCollegeMasterService.getAllColleges(pageNo, pageSize), HttpStatus.OK);
    }

    @GetMapping("/getCollege/{id}")
    public ResponseEntity<VhitCollegeMaster> getCollege(@PathVariable int id) throws RecordNotFoundException {

        return new ResponseEntity<>(vhitCollegeMasterService.getCollege(id), HttpStatus.OK);
    }

    @DeleteMapping("/deleteCollege/{id}")
    public ResponseEntity<String> deleteCollege(@PathVariable int id) throws RecordNotFoundException {

        return new ResponseEntity<>(vhitCollegeMasterService.deleteCollege(id), HttpStatus.OK);
    }
}
