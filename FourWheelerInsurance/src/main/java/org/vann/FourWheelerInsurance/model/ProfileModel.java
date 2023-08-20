package org.vann.FourWheelerInsurance.model;

 

public class ProfileModel {
    private int id;
    private int customerId;
    private String aplyname;
    private String  aplyaddress;
    private long aplynumber;
    private String aplydate;
    private String aplyvehno;
    private String aplyvehmodel;
    
    public ProfileModel() {
        super();
    }
    public ProfileModel(int id, int customerId, String aplyname, String aplyaddress, long aplynumber, String aplydate,
            String aplyvehno, String aplyvehmodel) {
        super();
        this.id = id;
        this.customerId = customerId;
        this.aplyname = aplyname;
        this.aplyaddress = aplyaddress;
        this.aplynumber = aplynumber;
        this.aplydate = aplydate;
        this.aplyvehno = aplyvehno;
        this.aplyvehmodel = aplyvehmodel;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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
    public long getAplynumber() {
        return aplynumber;
    }
    public void setAplynumber(long aplynumber) {
        this.aplynumber = aplynumber;
    }
    public String getAplydate() {
        return aplydate;
    }
    public void setAplydate(String aplydate) {
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