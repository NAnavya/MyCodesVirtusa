package com.hiringandtracking.services;

import com.hiringandtracking.dto.VhitCollegeMasterDto;
import com.hiringandtracking.entity.VhitCollegeMaster;
import com.hiringandtracking.exceptions.RecordNotFoundException;
import com.hiringandtracking.repo.VhitCollegeMasterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class VhitCollegeMasterService {

    @Autowired
    VhitCollegeMasterRepo vhitCollegeMasterRepo;

    private static final String DATE_PATTERN ="dd-MM-yyyy";

    /*
     addCollege saves a College record in db
     @params  VhitCollegeMasterDto
     @returns saved student record
    */
    public VhitCollegeMaster addCollege(VhitCollegeMasterDto vhitCollegeMasterDto) throws ParseException {

        VhitCollegeMaster vhitCollegeMaster = new VhitCollegeMaster();

        vhitCollegeMaster.setVmcName(vhitCollegeMasterDto.getVmcName());
        vhitCollegeMaster.setVmcAddress(vhitCollegeMasterDto.getVmcAddress());
        vhitCollegeMaster.setVmcTpoMail(vhitCollegeMasterDto.getVmcTpoMail());
        vhitCollegeMaster.setVmcTpoName(vhitCollegeMasterDto.getVmcTpoName());
        vhitCollegeMaster.setVmcCoeMouDate(
                new Date(new SimpleDateFormat(DATE_PATTERN)
                        .parse(vhitCollegeMasterDto.getVmcCoeMouDate()).getTime()
        ));
        vhitCollegeMaster.setVmcCity(vhitCollegeMasterDto.getVmcCity());
        vhitCollegeMaster.setVmcState(vhitCollegeMasterDto.getVmcState());
        vhitCollegeMaster.setVmcPinCode(vhitCollegeMasterDto.getVmcPinCode());
        vhitCollegeMaster.setVmcStatus(vhitCollegeMasterDto.getVmcStatus());

        return vhitCollegeMasterRepo.save(vhitCollegeMaster);
    }



    /*
      updateCollege updates a student record from db
      @params int id,vhitCollegeMasterDto
      @returns updated student record
      @throws RecordNotFoundException
    */
    public VhitCollegeMaster updateCollege(int id, VhitCollegeMasterDto vhitCollegeMasterDto) throws RecordNotFoundException, ParseException {

        VhitCollegeMaster vhitCollegeMaster = vhitCollegeMasterRepo.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Record you are trying to edit doesn't exist please check"));

        vhitCollegeMaster.setVmcName(vhitCollegeMasterDto.getVmcName());
        vhitCollegeMaster.setVmcAddress(vhitCollegeMasterDto.getVmcAddress());
        vhitCollegeMaster.setVmcTpoMail(vhitCollegeMasterDto.getVmcTpoMail());
        vhitCollegeMaster.setVmcTpoName(vhitCollegeMasterDto.getVmcTpoName());
        vhitCollegeMaster.setVmcCoeMouDate(
                new Date(new SimpleDateFormat(DATE_PATTERN)
                        .parse(vhitCollegeMasterDto.getVmcCoeMouDate()).getTime()
                ));
        vhitCollegeMaster.setVmcCity(vhitCollegeMasterDto.getVmcCity());
        vhitCollegeMaster.setVmcState(vhitCollegeMasterDto.getVmcState());
        vhitCollegeMaster.setVmcPinCode(vhitCollegeMasterDto.getVmcPinCode());
        vhitCollegeMaster.setVmcStatus(vhitCollegeMasterDto.getVmcStatus());

        return vhitCollegeMasterRepo.save(vhitCollegeMaster);
    }



    /*
     getAllColleges retrieves a College record from db in page
     @params  int pageNo,int pageSize
     @returns list of VhitCollegeMaster
    */
    public List<VhitCollegeMaster> getAllColleges(int pageNo, int pageSize) throws RecordNotFoundException {

        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<VhitCollegeMaster> pages = vhitCollegeMasterRepo.findAll(pageable);

        if(pages.hasContent()){
            return pages.getContent();
        }else {
            throw new RecordNotFoundException("No records Available");
        }
    }



    /*
     getCollege retrieves a College record from db
     @params int id
     @returns a student record
     @throws RecordNotFoundException
    */
    public VhitCollegeMaster getCollege(int id) throws RecordNotFoundException {

        VhitCollegeMaster vhitCollegeMaster = vhitCollegeMasterRepo.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Record you are trying to edit doesn't exist please check"));

        return vhitCollegeMaster;
    }



    /*
     deleteCollege deletes a College record from db
     @params int id
     @returns a string "College Deleted"
     @throws RecordNotFoundException
    */
    public String deleteCollege(int id) throws RecordNotFoundException {

        VhitCollegeMaster vhitCollegeMaster = vhitCollegeMasterRepo.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Record you are trying to delete doesn't exist please check"));

        if (vhitCollegeMaster != null) {
        	
        	vhitCollegeMasterRepo.deleteById(id);

            return "College Deleted";
        }
        return "Record you are trying to delete doesn't exist";
    }
}
