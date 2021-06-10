package com.rajsuvariya.noteslist.model;

public class AddUpdateNoteRequestModel {
    String note;

    public AddUpdateNoteRequestModel(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    @Override
    public String toString() {
        return "AddNoteRequestModel{" +
                "note='" + note + '\'' +
                '}';
    }
}
