/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.trunkclub.service;

import java.util.Date;
import java.util.List;
import org.trunkclubservice.model.ToDo;

/**
 *
 * @author ASafwat
 */
public interface ITrunkClubService {
    public void CreateTodo(String username,String toDo,Date dueDate);
    public void CreateTodo(long userid,String ToDo,Date dueDate);
    public ToDo MarkAsComplete(long todoID);
    public List<ToDo> RetrieveToDo(long userID);
    public List<ToDo> RetrieveToDo(String userName);
    public List<ToDo> RetrieveInComplete(long userID);
    public List<ToDo> RetrieveInComplete(String userName);
}
