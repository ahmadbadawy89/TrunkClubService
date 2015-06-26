/*
Done By: Ahmed Badawy
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
//the Data Access Object of the User
public class UserToDoDao {

    EntityManager em;
    
    //constructor
    public UserToDoDao() {

    }
    
    //setter to set the entity manager
    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    //function to get user by username
    /*Inputs
    username: string for the name of the user 
      Output
    outputs a user that has this username or null if it doesn't exist
    */
    public UserToDo getUser(String username) {
        UserToDo user = null;
        Query query = em.createQuery("select u from UserToDo u where u.userName = :name");
        query.setParameter("name", username);
        List result = query.getResultList();
        if (!result.isEmpty()) {
            user = (UserToDo) result.get(0);
        }
        return user;
    }

    //function to update user
    /*Inputs
    user: user that needs updating
      Output
    outputs a user that has been updated
    */
    public UserToDo UpdateUser(UserToDo user) {
        user = em.merge(user);
        return user;
    }

    //function to get user by user ID
    /*Inputs
    userid: long for the user ID
      Output
    outputs a user that has this id or null if it doesn't exist
    */
    public UserToDo getUser(long userid) {
        UserToDo user = null;
        user = em.find(UserToDo.class, userid);
        return user;
    }

}
