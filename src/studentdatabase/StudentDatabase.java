/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import utilities.DatabaseDriver;
import utilities.DatabaseHandler;

/**
 *
 * @author theki
 */
public class StudentDatabase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        /*
        sql script
        create table student (id int primary key,name varchar(80),gpa double);
        
        */
        String driver = "org.apache.derby.jdbc.ClientDriver";
        String url = "jdbc:derby://localhost:1527/student";
        String user = "app";
        String passwd = "app";
        DatabaseDriver dbDriver = new DatabaseDriver(driver, url, user, passwd);
        DatabaseHandler dbHandler = new DatabaseHandler(dbDriver);
        Student std1 = new Student(1, "John", 1.2);
        Student std2 = new Student(2, "Marry", 2.2);
        Student std3 = new Student(3, "Marry3", 3.2);
        StudentTable.insertStudent(dbHandler, std1);
        StudentTable.insertStudent(dbHandler, std2);
        StudentTable.insertStudent(dbHandler, std3);
//        Student std4 = new Student(3, "Marry3update", 3.3);
//        StudentTable.updateStudent(dbHandler, std4);
//        StudentTable.removeStudent(dbHandler, std1);
        ArrayList<Student> studentList = StudentTable.findAllStudent(dbHandler);
        if (studentList != null) {
            printAllStudent(studentList);
        }
        dbHandler.closeConnection();
    }
    
    public static void printAllStudent(ArrayList<Student> stdList) {
        for(int i = 0; i < stdList.size(); i++) {
            System.out.print(stdList.get(i).getId() + " ");
            System.out.print(stdList.get(i).getName() + " ");
            System.out.println(stdList.get(i).getGPA() + " ");
        }
        
    }
    
}
