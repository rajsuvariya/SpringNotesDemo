package com.rajsuvariya.noteslist.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty
    private long id;
    private String note;
    private Date createOn;
    private Date updatedOn;
    private String status;
    private Boolean isDeleted;

    public Note() {
    }

    public Note(String note, Date createOn) {
        this.note = note;
        this.createOn = createOn;
        this.updatedOn = createOn;
        this.status = "active";
        this.isDeleted = false;
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

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void updateIsDeleted(Boolean deleted) {
        this.isDeleted = deleted;
        this.updatedOn = new Date();
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