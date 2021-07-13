package com.bootcamp.grupo4.diploma.entities;

public class Subject {
    private String subject;
    private int note;

    public Subject() {
    }

    public Subject(String subject, int note) {
        this.subject = subject;
        this.note = note;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }
}
