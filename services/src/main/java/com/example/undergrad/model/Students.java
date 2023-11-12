package com.example.undergrad.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Students {
    private int student_id;
    private String name;

    public int getStudent_id() {
        return student_id;
    }
    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
//    private startTime;
//    private endTime;
}
