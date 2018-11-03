package com.erp.demo.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "todo")
public class ToDoEvent implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private Timestamp time;
    private Boolean hasDone;

    public void setHasDone(boolean b) {
        hasDone = b;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTime(Timestamp timestamp) {
        time = timestamp;
    }
}