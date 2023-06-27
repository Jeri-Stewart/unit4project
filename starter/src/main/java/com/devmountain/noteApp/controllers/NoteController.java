package com.devmountain.noteApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.devmountain.noteApp.services.NoteService;
import com.devmountain.noteApp.dtos.NoteDto;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;

    // get notes for specific user
    @GetMapping("/user/{userId}")
    public List<NoteDto> getNotesByUser(@PathVariable Long userId){
        return noteService.getAllNotesByUserId(userId);
    }

    // add notes for specific user
    @PostMapping("/user/{userId}")
    public void addNote(@RequestBody NoteDto noteDto, @PathVariable Long userId) {
        noteService.addNote(noteDto, userId);
    }

    // update notes for specific user
    @PutMapping
    public void updateNote(@RequestBody NoteDto noteDto){
        noteService.updateNoteById(noteDto);
    }

    //delete notes for specific user
    @DeleteMapping("/{noteId}")
    public void deleteNoteById(@PathVariable Long noteId){
        noteService.deleteNoteById(noteId);
    }

    // get specific note by id
    @GetMapping("/{noteId}")
    public Optional<NoteDto> getNotebyId(@PathVariable Long noteId) {
        return noteService.getNoteById(noteId);
    }


}
