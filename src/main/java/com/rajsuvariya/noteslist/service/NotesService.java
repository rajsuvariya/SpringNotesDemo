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
            return notesRepository.findById(id).get();
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
            notesRepository.deleteById(id);
        }
    }

    public Note updateNote(long id, String note) {
        if (notesRepository.existsById(id)) {
            Note note1 = notesRepository.findById(id).get();
            note1.updateNote(note);
            notesRepository.save(note1);
            return note1;
        } else {
            throw new Exception400("No note found with id " + id);
        }
    }

    public List<Note> getAllNotes() {
        List<Note> notes = new ArrayList<>();
        for (Note note : notesRepository.findAll()) {
            notes.add(note);
        }
        return notes;
    }

    public Note completeNote(long id) {
        if (notesRepository.existsById(id)) {
            Note note1 = notesRepository.findById(id).get();
            note1.updateStatus("completed");
            notesRepository.save(note1);
            return note1;
        } else {
            throw new Exception400("No note found with id " + id);
        }
    }
}
