package ru.devmark.example.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.devmark.example.model.MyRecord;
import ru.devmark.example.service.HighloadService;

@RestController
public class HighloadController {

    private final HighloadService highloadService;

    public HighloadController(HighloadService highloadService) {
        this.highloadService = highloadService;
    }

    @GetMapping("/{id}")
    public MyRecord getOrCreateRecord(@PathVariable int id) {
        return highloadService.getOrCreateRecord(id);
    }

    @PutMapping("/{id}")
    public MyRecord createOrUpdateRecord(@PathVariable int id) {
        return highloadService.createOrUpdateRecord(id);
    }

    @DeleteMapping("/{id}")
    public String deleteRecord(@PathVariable int id) {
        highloadService.deleteRecord(id);
        return "Record deleted";
    }
}
