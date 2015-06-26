/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.trunkclub.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.trunkclubservice.daos.ToDoDao;
import org.trunkclubservice.daos.UserToDoDao;
import org.trunkclubservice.model.ToDo;
import org.trunkclubservice.model.UserToDo;

/**
 *
 * @author ASafwat
 */
public class TrunkClubService implements ITrunkClubService {
    
    private EntityManagerFactory emf;
    private EntityManager em;
    private UserToDoDao userDao;
    private ToDoDao todoDao;
    
    public TrunkClubService(){
        emf=Persistence.createEntityManagerFactory("TrunkClubServicePU");
        em=emf.createEntityManager();
        userDao=new UserToDoDao();
        todoDao=new ToDoDao();
        userDao.setEm(em);
        todoDao.setEm(em);
    }

    @Override
    public void CreateTodo(String username, String toDo, Date dueDate) {
        try{
        em.getTransaction().begin();
        UserToDo user=userDao.getUser(username);
        if(user==null)
            user=new UserToDo(username);
        ToDo todo=new ToDo(toDo, dueDate, false, user);
        user.getToDos().add(todo);
        userDao.UpdateUser(user);
        em.getTransaction().commit();
        }catch(Exception ex){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
        }
        finally{
            em.close();
        }
    }

    @Override
    public void CreateTodo(long userid, String ToDo, Date dueDate) {
        try{
        em.getTransaction().begin();
        UserToDo user=userDao.getUser(userid);
        ToDo todo=new ToDo(ToDo, dueDate, false, user);
        user.getToDos().add(todo);
        userDao.UpdateUser(user);
        em.getTransaction().commit();
        }
        catch(Exception ex){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
        }
        finally{
            em.close();
        }
    }

    @Override
    public ToDo MarkAsComplete(long todoID) {
        ToDo todo = null;
        try{
        em.getTransaction().begin();
        todo=todoDao.getToDo(todoID);
        todo.setDone(true);
        todo= todoDao.UpdateToDo(todo);
        em.getTransaction().commit();
        }catch(Exception ex){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
        }
        finally{
            em.close();
        }
        return todo;
    }

    @Override
    public List<ToDo> RetrieveToDo(String userName) {
        List<ToDo> output=null;
        try{
        em.getTransaction().begin();
        UserToDo user=userDao.getUser(userName);        
        if(user!=null)
            output=user.getToDos();
        em.getTransaction().commit();
        }catch(Exception ex){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
        }
        finally{
            em.close();
        }
        return output;
        
    }

    @Override
    public List<ToDo> RetrieveInComplete(String userName) {
        List<ToDo> output=null;
        try{
        em.getTransaction().begin();
        UserToDo user=userDao.getUser(userName);
        if (user!=null)
            output=getInComplete(user.getToDos());
        em.getTransaction().commit();
        }catch(Exception ex){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
        }
        finally{
            em.close();
        }
        return output;
    }
    
    @Override
    public List<ToDo> RetrieveToDo(long userID) {
        List<ToDo> output=null;
        try{
        em.getTransaction().begin();
        UserToDo user=userDao.getUser(userID);        
        if(user!=null)
            output= user.getToDos();
        em.getTransaction().commit();
        }catch(Exception ex){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
        }
        finally{
            em.close();
        }
        return output;
    }

    @Override
    public List<ToDo> RetrieveInComplete(long userID) {
        List<ToDo> output=null;
        try{
        em.getTransaction().begin();
        UserToDo user=userDao.getUser(userID); 
        if (user!=null)
            output=getInComplete(user.getToDos());
        em.getTransaction().commit();
        }catch(Exception ex){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
        }
        finally{
            em.close();
        }
        return output;
    }

    private List<ToDo> getInComplete(List<ToDo> toDos) {
        List<ToDo> output=new ArrayList<>();
        for (ToDo toDo : toDos) {
            if (!toDo.isDone()) {
                output.add(toDo);
            }
        }
        return output;
    }
}
