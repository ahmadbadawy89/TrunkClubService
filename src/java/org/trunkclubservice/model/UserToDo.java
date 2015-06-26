/*
Done By: Ahmed Badawy
 */
package org.trunkclubservice.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ASafwat
 */

//Entity Class for the user
@Entity
@XmlRootElement
public class UserToDo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//the generation type is used as identity because the embedded java DB doesn't suppoert sequence
    private long id;//the id for the user
    @Column(unique = true)
    private String userName;//string for the username
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<ToDo> toDos = new ArrayList();//the relation for the todo and the user (one to many)

    public UserToDo(String userName) {
        this.userName = userName;
    }

    @XmlTransient
    public List<ToDo> getToDos() {
        return toDos;
    }

    public void setToDos(List<ToDo> toDos) {
        this.toDos = toDos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserToDo() {
    }

}
