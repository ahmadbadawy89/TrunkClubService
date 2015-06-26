package org.trunkclubservice.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.trunkclubservice.model.UserToDo;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-06-25T00:27:44")
@StaticMetamodel(ToDo.class)
public class ToDo_ { 

    public static volatile SingularAttribute<ToDo, Date> dueDate;
    public static volatile SingularAttribute<ToDo, Long> id;
    public static volatile SingularAttribute<ToDo, String> toDoItem;
    public static volatile SingularAttribute<ToDo, Boolean> done;
    public static volatile SingularAttribute<ToDo, UserToDo> user;

}