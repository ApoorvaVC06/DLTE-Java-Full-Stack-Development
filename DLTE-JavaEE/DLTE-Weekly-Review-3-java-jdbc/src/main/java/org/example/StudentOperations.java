package org.example;

import oracle.jdbc.OracleDriver;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;
import java.util.Scanner;

public class StudentOperations implements StudentRemote {
    Scanner scanner = new Scanner(System.in);
    Student student = new Student();
    Address address=new Address();
    private Connection connection;
    private PreparedStatement preparedStatement;

    @Override
    public void InsertDetails() throws IOException, SQLException {

        System.out.println("Enter registration number");
        student.setReg_no(scanner.nextInt());
        System.out.println("Enter Name of the student");
        student.setName(scanner.next());
        System.out.println("Enter age of the student");
        student.setAge(scanner.nextInt());
        System.out.println("Enter email");
        student.setEmail(scanner.nextLine());

        System.out.println("Enter door number");
        address.setDoor(scanner.nextLine());
        System.out.println("Enter street");
        address.setStreet(scanner.nextLine());
        System.out.println("Enter city");
        address.setCity(scanner.nextLine());
        System.out.println("Enter pincode");
        address.setPincode(scanner.nextInt());
        InsertDB(student);
    }

    public void connect() throws SQLException {
        Driver driver=new OracleDriver();
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        String oracleUrl = "jdbc:oracle:thin:@localhost:1521:xe";
        connection = DriverManager.getConnection(oracleUrl,"system","Apoorva@098");
        preparedStatement = connection.prepareStatement("alter session set current_schema=APOORVA");
        preparedStatement.executeQuery();
        System.out.println("Connected");

    }

    @Override
    public void InsertDB(Student student) throws SQLException {
       String query="insert into students values (?,?,?,?,stud_seq.nextval)";
    preparedStatement=connection.prepareStatement(query);
        preparedStatement.setInt(1,student.getReg_no());
        preparedStatement.setString(2,student.getName());
        preparedStatement.setInt(3,student.getAge());
        preparedStatement.setString(4,student.getEmail());
        int ack1=preparedStatement.executeUpdate();
        preparedStatement = connection.prepareStatement("insert into address values(add_seq.CURRVAL,?,?,?,?)");
        preparedStatement.setString(1,address.getDoor());
        preparedStatement.setString(2,address.getStreet());
        preparedStatement.setString(3,address.getCity());
        preparedStatement.setInt(4,address.getPincode());
        int ack2=preparedStatement.executeUpdate();
        if(ack1>0 && ack2>0)
        System.out.println("Inserted successfully");
        else System.out.println("Insertion failed.Try to insert again");
    }

    @Override
    public void GetDetails() throws SQLException {
           String qry="select * from students";
           ResultSet resultSet= (ResultSet) connection.prepareStatement(qry);
           while(resultSet.next()){
              Student s = new Student();
               s.setReg_no(resultSet.getInt("regno"));
               s.setName(resultSet.getNString("name"));
               s.setAge(resultSet.getInt("age"));
               s.setEmail(resultSet.getString("email"));
               System.out.println(s.toString());
           }
    }
}

