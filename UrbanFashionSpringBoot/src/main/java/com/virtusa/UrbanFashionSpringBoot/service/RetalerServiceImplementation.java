package com.virtusa.UrbanFashionSpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.UrbanFashionSpringBoot.dao.ProductRepository;
import com.virtusa.UrbanFashionSpringBoot.dao.RetailerRepository;
import com.virtusa.UrbanFashionSpringBoot.exception.ExistException;
import com.virtusa.UrbanFashionSpringBoot.model.ProductModel;
import com.virtusa.UrbanFashionSpringBoot.model.RetailerModel;

@Service
public class RetalerServiceImplementation implements RetailerService {

	@Autowired
	RetailerRepository rerepo;

	@Autowired
	ProductRepository prepo;

	@Override
	public String addProducts(RetailerModel model) {

		String res = null;
		try {
			if(!(rerepo.existsByPcode(model.getPcode()))){
				if(!(rerepo.existsByRid(model.getRid()))) {
					rerepo.save(model);
					throw new ExistException("Product Added");
				}
				else
					throw new ExistException("Rid Already Exists");
			}
			else {
				updateProducts(model,model.getPcode());
			}
		}
		catch(ExistException e) {
			res = e.getMessage();
		}
		return res;

	}

	private String updateProducts(RetailerModel model, int pcode) {
		RetailerModel remodel = new RetailerModel();
		ProductModel pmodel = new ProductModel();
		remodel = rerepo.findByPcode(pcode);
		remodel.setPquantity(remodel.getPquantity()+model.getPquantity());
		remodel.setPcost(model.getPcost());
		if(prepo.existsByPcode(remodel)) {
			pmodel = prepo.findByPcode(remodel);
			pmodel.setOcost(remodel.getPcost());
			pmodel.setBalance(pmodel.getScost()-pmodel.getOcost());
			rerepo.save(remodel);
			prepo.save(pmodel);
			throw new ExistException("Updated !!");
		}
		else
		{
			rerepo.save(remodel);
			throw new ExistException("Updated!!");
		}
	}

}
