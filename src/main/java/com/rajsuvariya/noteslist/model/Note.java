package com.rajsuvariya.noteslist.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String note;
    private Date createOn;
    private Date updatedOn;
    private String status;

    public Note() {
    }

    public Note(String note, Date createOn) {
        this.note = note;
        this.createOn = createOn;
        this.updatedOn = createOn;
        this.status = "active";
    }

    public String getNote() {
        return note;
    }

    public String getStatus() {
        return status;
    }

    public Date getCreateOn() {
        return createOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void updateNote(String note) {
        this.note = note;
        this.updatedOn = new Date();
    }

    public void updateStatus(String status) {
        this.status = status;
        this.updatedOn = new Date();
    }
}