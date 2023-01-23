package Clases;

public class CDepartments {
    public  int id;
    public String name;

    public CDepartments(int id , String name) {
        this.id = id;
        this.name = name;
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


}
