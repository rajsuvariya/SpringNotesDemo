package com.rajsuvariya.noteslist.repository;

import com.rajsuvariya.noteslist.model.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepository extends CrudRepository<Note, Long> {
}