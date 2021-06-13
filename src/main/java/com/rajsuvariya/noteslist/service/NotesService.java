package com.rajsuvariya.noteslist.service;

import com.rajsuvariya.noteslist.exceptions.Exception400;
import com.rajsuvariya.noteslist.model.Note;
import com.rajsuvariya.noteslist.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class NotesService {

    @Autowired
    NotesRepository notesRepository;

    public Note getNote(long id) {
        if (notesRepository.findById(id).isPresent()) {
            Note note = notesRepository.findById(id).get();
            if (note.getDeleted()) {
                throw new Exception400("Note with id " + id + " is deleted cannot get the deleted note");
            }
            return note;
        } else {
            throw new Exception400("No note found with id " + id);
        }
    }

    public Note addNote(String note) {
        Note note1 = new Note(note, new Date());
        notesRepository.save(note1);
        return note1;
    }

    public void deleteNote(long id) {
        if (notesRepository.existsById(id)) {
            Note note1 = notesRepository.findById(id).get();
            if (note1.getDeleted()) {
                throw new Exception400("Note with id " + id + " is deleted cannot delete the deleted note");
            }
            note1.updateIsDeleted(true);
            notesRepository.save(note1);
        }
    }

    public Note updateNote(long id, String note) {
        if (notesRepository.existsById(id)) {
            Note note1 = notesRepository.findById(id).get();
            if (note1.getDeleted()) {
                throw new Exception400("Note with id " + id + " is deleted cannot update the deleted note");
            }
            note1.updateNote(note);
            notesRepository.save(note1);
            return note1;
        } else {
            throw new Exception400("No note found with id " + id);
        }
    }

    public List<Note> getAllNotes() {
        List<Note> notes = new ArrayList<>();
        for (Note note : notesRepository.getAllNonDeletedNotes()) {
            notes.add(note);
        }
        return notes;
    }

    public List<Note> getAllDeletedNotes() {
        List<Note> notes = new ArrayList<>();
        for (Note note : notesRepository.getAllDeletedNotes()) {
            notes.add(note);
        }
        return notes;
    }

    public Note completeNote(long id) {
        if (notesRepository.existsById(id)) {
            Note note1 = notesRepository.findById(id).get();
            if (note1.getDeleted()) {
                throw new Exception400("Note with id " + id + " is deleted cannot complete the deleted note");
            }
            note1.updateStatus("completed");
            notesRepository.save(note1);
            return note1;
        } else {
            throw new Exception400("No note found with id " + id);
        }
    }
}
