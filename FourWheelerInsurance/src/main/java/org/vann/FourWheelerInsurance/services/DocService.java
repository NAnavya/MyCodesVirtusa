package org.vann.FourWheelerInsurance.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vann.FourWheelerInsurance.entities.Document;
import org.vann.FourWheelerInsurance.repositories.DocumentRepository;

@Service
public class DocService {
	@Autowired
	private DocumentRepository documentRepository;
	final private static org.apache.log4j.Logger log = org.apache.log4j.LogManager.getLogger(FeedBackService.class);

	public Document saveDetails(Document document) {
		return documentRepository.save(document);

	}

	public List<Document> getUserDocs(String aplyname) {

		return documentRepository.findByAplyname(aplyname);
	}

	public Document savePlan(Document document) {

		Document doc = new Document();
		doc.setAplyname(document.getAplyname());
		doc.setAplyaddress(document.getAplyaddress());
		doc.setAplynumber(document.getAplynumber());
		doc.setAplydate(document.getAplydate());
		doc.setAplyvehno(document.getAplyvehno());
		doc.setAplyvehmodel(document.getAplyvehmodel());
		return documentRepository.save(doc);
	}

	public String deleteDocs(String aplyname) {

		documentRepository.deleteByAplyname(aplyname);
		return "document removed";
	}

	public void saveDocument(Document document) {
		documentRepository.save(document);
		log.info("Docuents  Successfully Registered");
	}

}