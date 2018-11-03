package com.erp.demo.repository;

import com.erp.demo.domain.ToDoEvent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TodoRepository extends CrudRepository<ToDoEvent, Long>{
    List<ToDoEvent> getAllByHasDoneFalse();
    ToDoEvent getById(Long id);
}
