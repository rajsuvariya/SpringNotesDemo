package com.rajsuvariya.noteslist.controller;

import com.rajsuvariya.noteslist.model.Note;
import com.rajsuvariya.noteslist.service.NotesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class NotesController {

    @Autowired
    private NotesService notesService;

    @GetMapping("note")
    @ResponseBody
    public Note getNote(@RequestParam long id) {
        return notesService.getNote(id);
    }

    @GetMapping("addNote")
    public Note addNote(@RequestParam String note) {
        return notesService.addNote(note);
    }

    @GetMapping("deleteNote")
    public void deleteNote(@RequestParam long id) {
        notesService.deleteNote(id);
    }

    @GetMapping("updateNote")
    public Note updateNote(@RequestParam long id, @RequestParam String note) {
        return notesService.updateNote(id, note);
    }

    @GetMapping("completeNote")
    public Note completeNote(@RequestParam long id) {
        return notesService.completeNote(id);
    }

    @GetMapping("allNotes")
    @ResponseBody
    public List<Note> getAllNotes() {
        return notesService.getAllNotes();
    }
}
