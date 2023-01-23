package Clases;

public class CPatients {
    public int id;
    public String Fname;
    public String Lname;
    public String dept_name;

    public int phone;

    public String nots;

    public CPatients(int id, String fname, String lname, String dept_name, int phone, String nots) {
        this.id = id;
        Fname = fname;
        Lname = lname;
        this.dept_name = dept_name;
        this.phone = phone;
        this.nots = nots;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getNots() {
        return nots;
    }

    public void setNots(String nots) {
        this.nots = nots;
    }
}
