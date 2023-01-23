package CheakConnection;

import CheakConnection.DBConnection;
import Clases.CDepartments;
import Clases.CDoctors;
import Clases.CPatients;
import Clases.CVisits;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

public class DBQuery {
    // Query Departments
    public static ObservableList selectDepartment () {
        ObservableList<CDepartments> listDep = FXCollections.observableArrayList();
        CDepartments departments;
        try {

            String sql = "Select * from DEPARTMENT";
            Connection connection = DBConnection.connect();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                listDep.add(new CDepartments(resultSet.getInt(1) ,
                        resultSet.getString(2)));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listDep;

    }
    public static boolean SearchDepartment(int cheakId) {
        boolean cheak = false;
        ArrayList<Integer> list = new ArrayList<>();
        try {

            String sql = "Select * from DEPARTMENT";
            Connection connection = DBConnection.connect();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                list.add(id);
            }

            if (list.contains(cheakId)){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cheak;
    }
    public static void insertDepartment (int id , String name) {
        String sql = "Insert INTO DEPARTMENT VALUES(" + id + ",\'"+name+"\')";
        excuteQuery(sql);

    }
    public static void updateDepartment(int id , String name) {
        String sql = "UPDATE DEPARTMENT SET NAME='"+name+ "'WHERE id="+id;
        excuteQuery(sql);

    }
    public static void deleteDepartment(int id ) {
        String sql = "DELETE FROM DEPARTMENT WHERE ID ="+id;
        excuteQuery(sql);

    }
    public static void excuteQuery(String sql) {
        Connection connection = DBConnection.connect();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);

        }catch (Exception E) {
            E.printStackTrace();
        }

    }

  // end Query Department

    // Start Methods Doctors
    public static ObservableList selectDoctors () {
        ObservableList<CDoctors> listDep = FXCollections.observableArrayList();
        CDoctors dectors;
        try {

            String sql = "select DOCTORS.ID , DOCTORS.NAME ,DOCTORS.PHONE , DEPARTMENT.NAME as dept_name from DOCTORS INNER JOIN DEPARTMENT on DOCTORS.DEPT_ID=DEPARTMENT.ID";

            Connection connection = DBConnection.connect();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                listDep.add(new CDoctors(resultSet.getInt(1) ,
                        resultSet.getString(2) , resultSet.getInt(3) ,
                        resultSet.getString(4)));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listDep;

    }
    public static void insertDoctors (int id , String name , int phone , int dept_id) {
       String sql = "Insert INTO DOCTORS VALUES(" + id + ",'" + name + "'," + phone + "," +dept_id+")";
        excuteQuery(sql);

    }

    public static void updateDoctor(int id , String name , int phone , int dept_id) {
        String sql = "UPDATE DOCTORS SET NAME='"+name+"' , PHONE =" +phone +
                ", DEPT_ID = " +dept_id + " WHERE id="+id;
        excuteQuery(sql);

    }
    public static void deleteDoctor(int id) {
        String sql = "DELETE FROM DOCTORS WHERE ID ="+id;
        excuteQuery(sql);
    }
    public static boolean searchDocId (int cheakId) {
        boolean cheak = false;
        ArrayList<Integer> list = new ArrayList<>();
        try {

            String sql = "Select * from DOCTORS";
            Connection connection = DBConnection.connect();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                list.add(id);
            }

            if (list.contains(cheakId)){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cheak;
    }

    // End Methods doctor

    // Start Patients
    public static ObservableList selectPatients () {
        ObservableList<CPatients> listPatient = FXCollections.observableArrayList();

        try {

            String sql = "select PATIENT.ID , PATIENT.FNAME ,PATIENT.Lname , DEPARTMENT.NAME as dept_name  ," +
                    " PATIENT.PHONE , PATIENT.NOTS from PATIENT INNER JOIN DEPARTMENT " +
                    "on PATIENT.DEPT_ID=DEPARTMENT.ID";


            Connection connection = DBConnection.connect();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                listPatient.add(new CPatients(resultSet.getInt(1) ,
                        resultSet.getString(2) , resultSet.getString(3) ,
                        resultSet.getString(4) , resultSet.getInt(5) ,
                        resultSet.getString(6)));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listPatient;

    }
    public static void insertPatients (int id , String Fname ,String LName ,int phone , int dept_id , String nots) {
        String sql = "Insert INTO PATIENT VALUES(" + id + ",'" + Fname + "','"+LName +"'," + phone + "," +dept_id+ "," +"'"+nots+"')";
        excuteQuery(sql);

    }

    public static void updatePatients (int id  , String Fname ,String LName ,int phone , String nots) {
        String sql = "UPDATE PATIENT SET FNAME = '" + Fname + "', LNAME = '" + LName +
                "' , phone = " + phone + ", NOTS = " + "'" + nots + "'" + " WHERE ID = " + id;
       // String sql = "UPDATE PATIENT SET FNAME='"+Fname+"' , PHONE =" +phone + " WHERE id="+id;
        excuteQuery(sql);

    }
    public static void deletePatients (int id) {
        String sql = "DELETE FROM PATIENT WHERE ID ="+id;
        excuteQuery(sql);
    }
    public static boolean searchPatId(int cheakId) {
        boolean cheak = false;
        ArrayList<Integer> list = new ArrayList<>();
        try {

            String sql = "Select * from PATIENT";
            Connection connection = DBConnection.connect();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                list.add(id);
            }

            if (list.contains(cheakId)){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cheak;
    }



    /// End patient

    // Start visits

    public static ObservableList selectVisits () {
        ObservableList<CVisits> list = FXCollections.observableArrayList();

        try {
             // INNER JOIN Between visits and Doctors , Vists and Patient

            String sql = "Select VISITS.id , DOCTORS.name ,CONCAT(CONCAT(PATIENT.FNAME , ' ') , " +
                    "PATIENT.LNAME) AS FULLNAME , VISITS.MEDICAL_REPORT  \n" +
                    "from (VISITS INNER JOIN DOCTORS ON VISITS.DOCTOR_ID = DOCTORS.ID) \n" +
                    " INNER JOIN PATIENT \n" +
                    " ON VISITS.PATIENT_ID = PATIENT.ID";


            Connection connection = DBConnection.connect();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                list.add(new CVisits(resultSet.getInt(1) ,
                        resultSet.getString(2) , resultSet.getString(3) ,
                        resultSet.getString(4)));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }
    public static void insertVisits (int id , int doctor_id , int patient_id , String medical_rep ) {

        String sql = "INSERT INTO VISITS VALUES (" + id + "," + doctor_id + "," + patient_id
                + ",'" + medical_rep + "')";
        excuteQuery(sql);

    }
   public static void updateVisits (int id , String medical_rep) {
        String sql = "UPDATE VISITS SET MEDICAL_REPORT = '" + medical_rep + "'" +
                      "WHERE ID = " + id;
        excuteQuery(sql);
   }

   public static void deleteVisits (int id) {
        String sql = "DELETE FROM VISITS WHERE ID = " + id;
        excuteQuery(sql);
   }

   public static boolean searchIDVisit (int cheakID) {
       boolean cheak = false;
       ArrayList<Integer> list = new ArrayList<>();
       try {

           String sql = "Select * from VISITS";
           Connection connection = DBConnection.connect();
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(sql);

           while (resultSet.next()) {
               int id = resultSet.getInt(1);
               list.add(id);
           }

           if (list.contains(cheakID)){
               return true;
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }

       return cheak;
   }
    // end visits




}
