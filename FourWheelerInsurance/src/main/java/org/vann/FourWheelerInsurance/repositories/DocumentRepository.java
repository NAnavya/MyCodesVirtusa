package org.vann.FourWheelerInsurance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vann.FourWheelerInsurance.entities.Document;



public interface DocumentRepository extends JpaRepository<Document, Long> {

List<Document> findByAplyname(String aplyname);

void deleteByAplyname(String aplyname);


}
