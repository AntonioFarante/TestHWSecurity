package com.example.TestHWSecurity.service;

import com.example.TestHWSecurity.entity.Note;
import com.example.TestHWSecurity.repo.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }


    public List<Note> listAll() {
        return noteRepository.findAll();
    }

    public void add(Note note) {
        noteRepository.save(note);
    }

    public void deleteById(Long id) {
        if (noteRepository.existsById(id)) {
            noteRepository.deleteById(id);
        }
        throw new IllegalArgumentException("No notes with id = " + id);
    }

    public void removeNote(Note note) {
        noteRepository.delete(note);
    }

    public void update(Note note) {
        noteRepository.save(note);

    }

    public Note getById(Long id) {
        if (noteRepository.existsById(id)) {
            return noteRepository.getById(id);
        }
        throw new IllegalArgumentException("There is no notes with id = " + id);
    }
}