/*
Done By:Ahmed Badawy
 */
package org.trunkclub.resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.trunkclub.service.ITrunkClubService;
import org.trunkclub.service.TrunkClubService;
import org.trunkclubservice.model.ToDo;

/**
 *
 * @author ASafwat
 */
@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TrunkClubResource {

    private ITrunkClubService service = new TrunkClubService();

    //function that retrieve data by id, the user ID is passed as query parameter in a GET request
    /*Inputs
     userID: long for the user ID
     Output
     returns a list of all the todos for the given user id
     */
    @GET
    @Path("RetrieveDataUserID")
    public List<ToDo> RetrieveDataByID(@QueryParam("userID") long userID) {
        return service.RetrieveToDo(userID);
    }

    //function that retrieve data by username, the user name is passed as query parameter in a GET request
    /*Inputs
     userName: String for the username
     Output
     returns a list of all the todos for the given username
     */
    @GET
    @Path("RetrieveDataUser")
    public List<ToDo> RetrieveDataByUserName(@QueryParam("userName") String userName) {
        return service.RetrieveToDo(userName);
    }

    //function that update a todo as done by using the todo id in a put request throws parse exception if input is wrong
    /*Inputs
     obj: a JSON object that has a value for ToDoID as a long
     Output
     returns the updated todo
     */
    @PUT
    @Path("SetDone")
    public ToDo SetDone(JsonObject obj) throws ParseException {
        long todoID = Long.parseLong(obj.get("ToDoID").toString());
        return service.MarkAsComplete(todoID);
    }

    //function that retrieve incomplete data by userID, the user ID is passed as query parameter in a GET request
    /*Inputs
     userID: long for the user ID
     Output
     returns a list of all the todos for the given user ID
     */
    @GET
    @Path("RetrieveInCompleteUserID")
    public List<ToDo> RetrieveInCompleteDataByID(@QueryParam("userID") long userID) {
        return service.RetrieveInComplete(userID);
    }

    //function that retrieve Incomplete data by username, the user name is passed as query parameter in a GET request
    /*Inputs
     userName: String for the username
     Output
     returns a list of all the todos for the given username
     */
    @GET
    @Path("RetrieveInCompleteUser")
    public List<ToDo> RetrieveInCompleteDataByUserName(@QueryParam("userName") String userName) {
        return service.RetrieveInComplete(userName);
    }

    //function that Add a todo for a user ID, if the ID is not available nothing happens
    /*Inputs
     obj: JSON object with values for the userID, toDo, dueData(as string in the format "yyyy-MM-dd")
     */
    @POST
    @Path("AddToDoUserID")
    public void AddToDo(JsonObject obj) throws ParseException {
        long userID = Long.parseLong(obj.get("userID").toString());
        String toDo = obj.get("toDo").toString();
        String dueDate = obj.get("Date").toString();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(dueDate);
        service.CreateTodo(userID, toDo, date);
    }

    //function that Add a todo for a username, if the username is not available a new user is created
    /*Inputs
     obj: JSON object with values for the username, toDo, dueData(as string in the format "yyyy-MM-dd")
     */
    @POST
    @Path("AddToDoUser")
    public void AddToDoID(JsonObject obj) throws ParseException {
        String userName = obj.get("userName").toString();
        String toDo = obj.get("toDo").toString();
        String dueDate = obj.get("Date").toString();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(dueDate);
        service.CreateTodo(userName, toDo, date);
    }
}
