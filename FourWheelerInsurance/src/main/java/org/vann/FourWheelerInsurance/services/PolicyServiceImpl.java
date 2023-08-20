package org.vann.FourWheelerInsurance.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vann.FourWheelerInsurance.entities.Policy;
import org.vann.FourWheelerInsurance.exceptions.PolicyNotFoundException;
import org.vann.FourWheelerInsurance.repositories.PolicyRepository;

@Service
@Transactional
public class PolicyServiceImpl implements PolicyService {
@Autowired
private PolicyRepository policyRepository;
@Override
public void updatePolicy(int id, Policy pol) {


Policy polUp=policyRepository.findById(id).orElseThrow(()->new PolicyNotFoundException("Policy Not Found"));
polUp.setId(pol.getId());
polUp.setPolicyName(pol.getPolicyName());
polUp.setPolicyPrice(pol.getPolicyPrice());
polUp.setNumberOfYearsPlan(pol.getNumberOfYearsPlan());
policyRepository.save(polUp);

}

@Override
public void deletePolicy(int id) {

policyRepository.deleteById(id);

}

@Override
public void insertpolicy(Policy pol) {

 policyRepository.save(pol);

}


@Override
public List<Policy> getPolicies() {
return policyRepository.findAll();
}

@Override
public  Policy getPolicy(int id) {

return policyRepository.findById(id).orElseThrow(()->new PolicyNotFoundException("policy Not Found"));
}

}

