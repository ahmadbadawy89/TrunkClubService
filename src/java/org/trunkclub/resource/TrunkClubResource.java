/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

    @GET
    @Path("RetrieveDataUserID")
    public List<ToDo> RetrieveDataByID(@QueryParam("userID") long userID) {
        return service.RetrieveToDo(userID);
    }

    @GET
    @Path("RetrieveDataUser")
    public List<ToDo> RetrieveDataByUserName(@QueryParam("userName") String userName) {
        //String userName = obj.get("userName").toString();
        return service.RetrieveToDo(userName);
    }

    @PUT
    @Path("SetDone")
    public ToDo SetDone(JsonObject obj) {
        long todoID = Long.parseLong(obj.get("ToDoID").toString());
        return service.MarkAsComplete(todoID);
    }

    @GET
    @Path("RetrieveInCompleteUserID")
    public List<ToDo> RetrieveInCompleteDataByID(@QueryParam("userID") long userID) {
        //long userID = Long.parseLong(obj.get("userID").toString());
        return service.RetrieveInComplete(userID);
    }

    @GET
    @Path("RetrieveInCompleteUser")
    public List<ToDo> RetrieveInCompleteDataByUserName(@QueryParam("userName") String userName) {
        //String userName = obj.get("userName").toString();
        return service.RetrieveInComplete(userName);
    }

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

    @POST
    @Path("AddToDoUser")
    public void AddToDoID(JsonObject obj) {
        String userName = obj.get("userName").toString();
        String toDo = obj.get("toDo").toString();
        Date date = (Date) obj.get("Date");
        service.CreateTodo(userName, toDo, date);
    }
}
