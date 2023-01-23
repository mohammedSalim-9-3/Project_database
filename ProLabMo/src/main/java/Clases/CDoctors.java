package Clases;

public class CDoctors {
    public int id;
    public String name;
    public int phone;
    public String dept_name;

    public CDoctors(int id , String name , int phone , String dept_name) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.dept_name = dept_name;

    }

    public void setId (int newId) {
        id = newId;
    }
    public int getId() {
        return id;
    }

    public void setName (String newName) {
        name = newName;
    }
    public String getName() {
        return name;
    }

    public void setPhone (int newPhone) {
        this.phone = newPhone;
    }
    public int getPhone() {
        return phone;
    }

    public void setDept_name (String dept_name) {
        this.dept_name = dept_name;
    }
    public String getDept_name () {
        return dept_name;
    }


}