package org.trunkclubservice.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.trunkclubservice.model.ToDo;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-06-25T00:27:44")
@StaticMetamodel(UserToDo.class)
public class UserToDo_ { 

    public static volatile SingularAttribute<UserToDo, Long> id;
    public static volatile ListAttribute<UserToDo, ToDo> toDos;
    public static volatile SingularAttribute<UserToDo, String> userName;

}