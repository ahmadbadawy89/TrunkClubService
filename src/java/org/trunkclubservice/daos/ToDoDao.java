/*
 Done By: Ahmed Badawy
 */
package org.trunkclubservice.daos;
import javax.persistence.EntityManager;
import org.trunkclubservice.model.ToDo;

/**
 *
 * @author ASafwat
 */
public class ToDoDao {

    EntityManager em;

    //constructor
    public ToDoDao() {

    }

    //setter to set the entity manager
    public void setEm(EntityManager em) {
        this.em = em;
    }

    //function to update todo
    /*Inputs
    todo: todo object to be updated
      Output
    outputs a todo after the update
    */
    public ToDo UpdateToDo(ToDo todo) {
        todo = (ToDo) em.merge(todo);
        return todo;
    }

    //function to get user by username
    /*Inputs
    todoID: long for the ID of the todo
      Output
    outputs the todo that is requested , null if it doesn't exist
    */
    public ToDo getToDo(long todoID) {
        ToDo todo = null;
        todo = (ToDo) em.find(ToDo.class, todoID);
        return todo;
    }
    
}
