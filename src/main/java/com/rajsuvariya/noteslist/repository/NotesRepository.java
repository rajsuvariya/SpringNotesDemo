package com.rajsuvariya.noteslist.repository;

import com.rajsuvariya.noteslist.model.Note;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepository extends CrudRepository<Note, Long> {

    @Query(value = "SELECT n FROM Note n WHERE n.isDeleted = false")
    Iterable<Note> getAllNonDeletedNotes();

    @Query(value = "SELECT n FROM Note n WHERE n.isDeleted = true")
    Iterable<Note> getAllDeletedNotes();
}