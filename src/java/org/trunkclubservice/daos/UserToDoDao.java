/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.trunkclubservice.daos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.trunkclubservice.model.UserToDo;

/**
 *
 * @author ASafwat
 */
public class UserToDoDao {
   
    EntityManager em ;
   
    
    public UserToDoDao(EntityManager em) {
        this.em=em;  
    } 

    public UserToDo getUser(String username) {
        UserToDo user=null;
        try {
            em.getTransaction().begin();
            Query query=em.createQuery("select u from UserToDo u where u.userName = :name");
            query.setParameter("name", username);
            List result=query.getResultList();
            if(result.size()!=0)
                user=(UserToDo) result.get(0);
            em.getTransaction().commit();
        }catch(Exception ex){
            System.out.printf("");
        }
        if(user==null)
            return null;
        return user;
    }

    public UserToDo UpdateUser(UserToDo user) {
        try{
        em.getTransaction().begin();
        user=em.merge(user);
        em.getTransaction().commit();
        }catch(Exception ex){
            System.out.printf("");
        }
        return user;
    }

    public UserToDo getUser(long userid) {
        UserToDo user=null;
        try{
        em.getTransaction().begin();
        user=em.find(UserToDo.class, userid);
        em.getTransaction().commit();
        }
        catch(Exception ex){
            System.out.printf("");}
        return user;
    }
    
}
