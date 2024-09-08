package com.mpt.journal.model;

public class StudentModel {
    private int Id;
    private String Name;
    private String LastName;
    private String FirstName;
    private String Course;
    private String Faculty;
    private String Yearofenrollment;

    public StudentModel(int id, String name, String lastName, String firstName, String course, String faculty, String yearofenrollment) {
        Id = id;
        Name = name;
        LastName = lastName;
        FirstName = firstName;
        Course = course;
        Faculty = faculty;
        Yearofenrollment = yearofenrollment;

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String course) {
        Course = course;
    }

    public String getFaculty() { return Faculty; }

    public void setFaculty(String faculty) {Faculty = faculty; }

    public String getYearofenrollment() { return  Yearofenrollment; }

    public void setYearofenrollment(String yearofenrollment) {Yearofenrollment = yearofenrollment; }
}
