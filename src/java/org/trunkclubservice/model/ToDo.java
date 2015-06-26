/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.trunkclubservice.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ASafwat
 */
@Entity
@XmlRootElement
public class ToDo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    String toDoItem;
    @Temporal(TemporalType.DATE)
    private Date dueDate;
    private boolean done;
    @ManyToOne
    @JoinColumn(name="user_id")
    private UserToDo user;

    public ToDo(String toDoItem, Date dueDate, boolean done, UserToDo user) {
        this.toDoItem = toDoItem;
        this.dueDate = dueDate;
        this.done = done;
        this.user = user;
    }

    public UserToDo getUser() {
        return user;
    }

    public void setUser(UserToDo user) {
        this.user = user;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getToDoItem() {
        return toDoItem;
    }

    public void setToDoItem(String toDoItem) {
        this.toDoItem = toDoItem;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public ToDo() {
    }
    
    
}
