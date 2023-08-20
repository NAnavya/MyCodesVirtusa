package org.vann.FourWheelerInsurance.services;
import java.util.List;

import org.vann.FourWheelerInsurance.entities.Policy;

public interface PolicyService {


public void updatePolicy(int id,Policy pol);
public void deletePolicy(int id);
public void insertpolicy(Policy pol);
public List<Policy> getPolicies();
public Policy getPolicy(int id);

} 