package com.learingSpring.lecture1.Basic.model;


public class Course {
    private int Long;
    private String subject;
    private String username;

    public Course(int aLong, String subject, String username) {
        Long = aLong;
        this.subject = subject;
        this.username = username;
    }

    public int getLong() {
        return Long;
    }

    public void setLong(int aLong) {
        Long = aLong;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
