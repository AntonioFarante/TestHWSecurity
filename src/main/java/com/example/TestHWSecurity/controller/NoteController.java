package com.example.TestHWSecurity.controller;

import com.example.TestHWSecurity.entity.Note;
import com.example.TestHWSecurity.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/note")
public class NoteController {

    private NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping(value = "/")
    public ModelAndView getHello() {
        ModelAndView result = new ModelAndView("home");
        return result;
    }

    @GetMapping(value = "/add")
    public String addNewNote(Model model) {
        return "add";
    }

    @GetMapping(value = "/{id}")
    public String noteDetails(@PathVariable(value = "id") Long id, Model model) {
        Note res = noteService.getById(id);
        model.addAttribute("notes", res);
        return "details";
    }

    @PostMapping(value = "/add")
    public String addNewNote(@RequestParam String title, @RequestParam String content, Model model) {
        Note note = new Note(title, content);
        noteService.add(note);

        return "redirect:/note/list";
    }

    @GetMapping(value = "/list")
    public ModelAndView getAllNotes() {
        ModelAndView result = new ModelAndView("list");
        result.addObject("notes", noteService.listAll());

        return result;
    }

    @GetMapping(value = "/edit")
    public String editNoteTest(@RequestParam(name = "id") Long id, Model model) {
        Note res = noteService.getById(id);
        model.addAttribute("notes", res);

        return "/edit";
    }

    @PostMapping(value = "/edit")
    public String updateNoteTest(@RequestParam(value = "id") Long id, @RequestParam String title, @RequestParam String content) throws Exception {
        Note note = noteService.getById(id);
        note.setTitle(title);
        note.setContent(content);
        noteService.update(note);

        return "redirect:/note/list";
    }

    @PostMapping(value = "/delete")
    public String deleteNote(@RequestParam(value = "id") Long id) {
        Note note = noteService.getById(id);
        noteService.removeNote(note);

        return "redirect:/note/list";
    }

}