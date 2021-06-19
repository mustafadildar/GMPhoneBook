package com.example.gmphonebook;

public class model {
    String fname,lname,ph,em;
    Integer id;
    public model(Integer id, String fname, String lname, String ph, String em) {
       this.id=id;
        this.fname = fname;
        this.lname = lname;
        this.ph = ph;
        this.em = em;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getEm() {
        return em;
    }

    public void setEm(String em) {
        this.em = em;
    }
}
