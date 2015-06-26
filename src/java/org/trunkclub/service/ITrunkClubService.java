/*
 Done By: Ahmed Badawy
 */

package org.trunkclub.service;

import java.util.Date;
import java.util.List;
import org.trunkclubservice.model.ToDo;

/**
 *
 * @author ASafwat
 */

//interface to the service that is responsible for the main functionality of the project 
public interface ITrunkClubService {
    //function to do a new todo 
    /*Inputs
    username: string for the name of the user (if user doesn't exist new user is persisted)
    toDo: string fot the todo item
    dueDate: date for the due date
    */
    public void CreateTodo(String username,String toDo,Date dueDate);
    
    //function to do a new todo 
    /*Inputs
    userid: long for the id of the user (if user doesn't exist nothing happens)
    toDo: string fot the todo item
    dueDate: date for the due date
    */
    public void CreateTodo(long userid,String ToDo,Date dueDate);
    
    //function to mark a todo as complete
    /*Inputs
    todoID: long for the toDo item ID 
      Outputs:
    Todo item that is updated(null if the todo item doesn't exist)
    */
    public ToDo MarkAsComplete(long todoID);
    
    //function retrieve the data using the user ID
    /*Inputs
    userID: long for the user ID
      Outputs:
    List of Todo items retreieve(null is returned if none)
    */
    public List<ToDo> RetrieveToDo(long userID);
    
    //function retrieve the data using the username
    /*Inputs
    userName: String for the username
      Outputs:
    List of Todo items retreieve(null is returned if none)
    */
    public List<ToDo> RetrieveToDo(String userName);
    
    //function retrieve the incomplete data using the user ID
    /*Inputs
    userID: long for the user ID
      Outputs:
    List of Todo items retreieve(null is returned if none)
    */
    public List<ToDo> RetrieveInComplete(long userID);
    
    //function retrieve the data using the username
    /*Inputs
    userID: long for the user ID
      Outputs:
    List of Todo items retreieve(null is returned if none)
    */
    public List<ToDo> RetrieveInComplete(String userName);
}
