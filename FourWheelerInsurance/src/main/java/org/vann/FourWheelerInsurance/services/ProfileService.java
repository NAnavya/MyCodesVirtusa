package org.vann.FourWheelerInsurance.services;

 

import java.util.List;

 

import javax.transaction.Transactional;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vann.FourWheelerInsurance.entities.Profile;
import org.vann.FourWheelerInsurance.repositories.ProfileRepository;

 


@Service
@Transactional
public class ProfileService {
    final private static org.apache.log4j.Logger log = org.apache.log4j.LogManager.getLogger(ProfileService.class);
    @Autowired
    private ProfileRepository profileRepository;

 

    public void saveProfile(Profile profile) {
        profileRepository.save(profile);
    log.info("Profile Saved Successfully");
    }

 


    public List<Profile> getAllProfile(){
    return profileRepository.findAll();
    }

 

}