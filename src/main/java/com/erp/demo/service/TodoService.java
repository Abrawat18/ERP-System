package com.erp.demo.service;

import com.erp.demo.domain.ToDoEvent;
import com.erp.demo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public List<ToDoEvent> getAllnonDoneEvents() {
        return todoRepository.getAllByHasDoneFalse();
    }

    public ToDoEvent getToDoEventById(Long id) {
        return todoRepository.getById(id);
    }

    public boolean DoneEventById(Long id) {
        ToDoEvent event = todoRepository.getById(id);
        if (null == event) {
            return false;
        }
        event.setHasDone(true);
        todoRepository.save(event);
        return true;
    }

    public boolean addToDoEvent(ToDoEvent newEvent) {
        if (newEvent.getName() == null || newEvent.getName().equals("")) {
            return false;
        }
        newEvent.setId(null);
        newEvent.setTime(new Timestamp(System.currentTimeMillis()));
        newEvent.setHasDone(false);
        todoRepository.save(newEvent);
        return true;
    }
}