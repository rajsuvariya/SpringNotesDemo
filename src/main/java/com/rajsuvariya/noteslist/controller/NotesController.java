package com.rajsuvariya.noteslist.controller;

import com.rajsuvariya.noteslist.model.AddUpdateNoteRequestModel;
import com.rajsuvariya.noteslist.model.Note;
import com.rajsuvariya.noteslist.service.NotesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class NotesController {

    @Autowired
    private NotesService notesService;

    @PostMapping("getNote/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Note getNote(@PathVariable long id) {
        return notesService.getNote(id);
    }

    @PostMapping("addNote")
    @ResponseStatus(HttpStatus.CREATED)
    public Note addNote(@RequestBody AddUpdateNoteRequestModel note) {
        log.debug("addNote " + note);
        return notesService.addNote(note.getNote());
    }

    @DeleteMapping("deleteNote/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteNote(@PathVariable long id) {
        notesService.deleteNote(id);
    }

    @PutMapping("updateNote/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Note updateNote(@PathVariable long id, @RequestBody AddUpdateNoteRequestModel note) {
        return notesService.updateNote(id, note.getNote());
    }

    @PutMapping("completeNote/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Note completeNote(@PathVariable long id) {
        return notesService.completeNote(id);
    }

    @PostMapping("allNotes")
    @ResponseStatus(HttpStatus.OK)
    public List<Note> getAllNotes() {
        return notesService.getAllNotes();
    }

    @PostMapping("allDeletedNotes")
    @ResponseStatus(HttpStatus.OK)
    public List<Note> getAllDeletedNotes() {
        return notesService.getAllDeletedNotes();
    }
}
