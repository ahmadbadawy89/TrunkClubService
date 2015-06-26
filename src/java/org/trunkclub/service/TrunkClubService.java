/*
Done By: Ahmed Badawy
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
//Service for implementing the interface responsible for all the main function of the service
public class TrunkClubService implements ITrunkClubService {
    
    private EntityManagerFactory emf;
    private EntityManager em;
    private UserToDoDao userDao;
    private ToDoDao todoDao;
    private final String persistantUnitName="TrunkClubServicePU";//variable for the persistance name
    //constructor that starts an entitymanager factory and entity manager and set them in the DAOs
    public TrunkClubService(){
        emf=Persistence.createEntityManagerFactory(persistantUnitName);
        em=emf.createEntityManager();
        userDao=new UserToDoDao();
        todoDao=new ToDoDao();
        userDao.setEm(em);
        todoDao.setEm(em);
    }

    @Override
    public void CreateTodo(String username, String toDo, Date dueDate) {
        try{
        em.getTransaction().begin();//begin transaction
        UserToDo user=userDao.getUser(username);//get user
        if(user==null)//check if user exists
            user=new UserToDo(username);//create new user if not exists
        ToDo todo=new ToDo(toDo, dueDate, false, user);
        user.getToDos().add(todo);//add the new todo to the list of todos
        userDao.UpdateUser(user);//persist the user
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
        user.getToDos().add(todo);//will throw exception if the user is null
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
        if(todo!=null){//check if a todo exists with this id
            todo.setDone(true);
            todo= todoDao.UpdateToDo(todo);//persist the todo
        }
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
        if(user!=null)//check if user exists
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
        if (user!=null)//checks if user exists
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
    //function to do get incomplete todos 
       /*Inputs
       toDos: list of the todos 
         Output
       a list of the todos that are not done
       */
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
