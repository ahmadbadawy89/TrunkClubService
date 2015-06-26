package org.trunkclubservice.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-06-26T05:04:26")
@StaticMetamodel(ToDo.class)
public class ToDo_ { 

    public static volatile SingularAttribute<ToDo, Date> dueDate;
    public static volatile SingularAttribute<ToDo, Long> id;
    public static volatile SingularAttribute<ToDo, String> toDoItem;
    public static volatile SingularAttribute<ToDo, Boolean> done;

}