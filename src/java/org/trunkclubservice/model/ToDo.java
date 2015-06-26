/*
 Done By: Ahmed Badawy
 */
package org.trunkclubservice.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ASafwat
 */
//Entity Class for the todo
@Entity
@XmlRootElement
public class ToDo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;//the id for the todo item
    String toDoItem;//the string of the todo
    @Temporal(TemporalType.DATE)//todo due date is stored as a date with no time in the database
    private Date dueDate;//the due date of the todo
    private boolean done;//a boolean to know if todo the is done or not

    public ToDo(String toDoItem, Date dueDate, boolean done, UserToDo user) {
        this.toDoItem = toDoItem;
        this.dueDate = dueDate;
        this.done = done;
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
