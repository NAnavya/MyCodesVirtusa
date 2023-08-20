package org.vann.FourWheelerInsurance.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.vann.FourWheelerInsurance.model.DocRequestModel;

@Entity
public class Document {
@Id
// @GeneratedValue(strategy = GenerationType.IDENTITY)
private String aplyname;
private String  aplyinsu;
private String  aplyaddress;
private Long aplynumber;
private LocalDate aplydate;
private String aplyvehno;
private String aplyvehmodel;
public Document(String aplyname, String aplyaddress, Long aplynumber, LocalDate aplydate, String aplyvehno,
String aplyvehmodel,String aplyinsu) {
super();
this.aplyname = aplyname;
this.aplyaddress = aplyaddress;
this.aplynumber = aplynumber;
this.aplydate = aplydate;
this.aplyvehno = aplyvehno;
this.aplyvehmodel = aplyvehmodel;
this.aplyinsu=aplyinsu;
}

public Document() {
super();

}

public Document(DocRequestModel docRequestModel) {

}

public String getAplyinsu() {
return aplyinsu;
}
public void setAplyinsu(String aplyinsu) {
this.aplyinsu = aplyinsu;
}
public String getAplyname() {
return aplyname;
}
public void setAplyname(String aplyname) {
this.aplyname = aplyname;
}
public String getAplyaddress() {
return aplyaddress;
}
public void setAplyaddress(String aplyaddress) {
this.aplyaddress = aplyaddress;
}
public Long getAplynumber() {
return aplynumber;
}
public void setAplynumber(Long aplynumber) {
this.aplynumber = aplynumber;
}
public LocalDate getAplydate() {
return aplydate;
}
public void setAplydate(LocalDate aplydate) {
this.aplydate = aplydate;
}
public String getAplyvehno() {
return aplyvehno;
}
public void setAplyvehno(String aplyvehno) {
this.aplyvehno = aplyvehno;
}
public String getAplyvehmodel() {
return aplyvehmodel;
}
public void setAplyvehmodel(String aplyvehmodel) {
this.aplyvehmodel = aplyvehmodel;
}

}