package com.erp.demo.controller;

import com.erp.demo.service.TodoService;
import com.erp.demo.domain.ToDoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;
    @PostMapping
    public String addToDoEvent(@RequestBody ToDoEvent toDoEvent) {
        if (null == toDoEvent) {
            return "fail to add todo event";
        }
        boolean ifAdd = todoService.addToDoEvent(toDoEvent);
        if (ifAdd) {
            return "success to add todo event";
        } else {
            return "fail to add todo event";
        }
    }
    @PutMapping("/{eventId}")
    public String didEvent(@PathVariable Long eventId) {
        if (null == eventId) {
            return "fail to did event";
        }
        boolean ifUpate = todoService.DoneEventById(eventId);
        if(ifUpate){
            return "success to did event";
        }else{
            return "fail to did event";
        }
    }
    @GetMapping
    public List<ToDoEvent> getToDoEvent() {
        List<ToDoEvent> eventList = todoService.getAllnonDoneEvents();
        return eventList;
    }
}
