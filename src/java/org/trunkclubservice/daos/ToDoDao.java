/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.trunkclubservice.daos;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.trunkclubservice.model.ToDo;


/**
 *
 * @author ASafwat
 */
public class ToDoDao {
    
    EntityManager em ;
  
    UserTransaction utx;
    public ToDoDao(EntityManager em) {
        this.em=em;
    }
    public ToDo UpdateToDo(ToDo todo){
         try{   
             
            em.getTransaction().begin();
            todo=(ToDo)em.merge(todo);
            em.getTransaction().commit();
            
           
        }catch(Exception ex){
           // em.getTransaction().rollback();
            }
            return todo;
    }
    public ToDo getToDo(long todoID){
        ToDo todo=null; 
        try{   
            
            em.getTransaction().begin();
            todo=(ToDo)em.find(ToDo.class, todoID);
            em.getTransaction().commit();
            
           
        }catch(Exception ex){
            //em.getTransaction().rollback();
        }
            return todo;
    }
    
    
}
