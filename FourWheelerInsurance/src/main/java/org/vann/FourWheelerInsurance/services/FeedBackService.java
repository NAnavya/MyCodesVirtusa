package org.vann.FourWheelerInsurance.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vann.FourWheelerInsurance.entities.FeedBack;
import org.vann.FourWheelerInsurance.repositories.FeedBackRepository;

@Service
@Transactional
public class FeedBackService {

final private static org.apache.log4j.Logger log = org.apache.log4j.LogManager.getLogger(FeedBackService.class);

@Autowired
private FeedBackRepository feedBackRepo;

public void saveFeedBack(FeedBack feedBack) {
feedBackRepo.save(feedBack);
log.info("FeedBack Saved Successfully");
}


public List<FeedBack> getAllFeedBack(){
return feedBackRepo.findAll();
}

}
