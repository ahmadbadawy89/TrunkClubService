# TrunkClubService

## To Run The Service:
*  You have to set the database first (Embedded Java DB was used):
  * open services tab in netbeans
  * create a new Java DB database (specify at least a username to the database)
* make sure that the persistance.xml file is refering to the database:
  * open persistance.xml file
  * under data source combobox choose new datasource
  * go through the wizard to get the newly created database
  * make sure to name the persistance unit name = TrunkClubServicePU
* Run the service on glassfish server


## Design Criteria:
 * Programming Language: Java (JEE). I am more familiar with Spring but I tried doing it in JEE because spring was not    mentioned in the task description. Could have used EJB but didn't have the time to learn it.
 * Database : embedded Java DB was used for simplicity as it is available on netbeans without any additional setup.
 * Data Persistance: JPA was used in this project. I could have done it with JDBC but I prefered to try it with JPA ORM (for the sake of learning).
 * Project: 
 the project consists of several layers:
  * Entity classes to model the data in the database (code first approach was used).
  * Data Access Models for the entity classes (DAO)
  * Service interface and Implementation that maps to the main functionality of the project.
  * Restful Web Service Controller to control how the data is passed and through which paths.

## Web Service Paths:
* Add a todo for a username, if the username is not available a new user is created
  * URL:        http://localhost:8080/TrunkClubService/AddToDoUser
  * Properties: 
     * Post Request passing a JSON object with values for the userName, toDo, dueData(as string in the format "yyyy-MM-dd").
     * A Parse Exception is thrown in case of non compatible JSON

* Add a todo for a user ID, if the ID is not available nothing happens
  * URL:        http://localhost:8080/TrunkClubService/AddToDoUserID
  * Properties: 
     * Post Request passing a JSON object with values for the userID, toDo, dueData(as string in the format "yyyy-MM-dd")
     * A Parse Exception is thrown in case of non compatible JSON

* Retrieve todo by user ID 
  * URL:        http://localhost:8080/TrunkClubService/RetrieveDataUserID
  * Properties: GET Request with parameter for the userID. Returns a todo list in JSON format

* Retrieve todo by user Name 
  * URL:        http://localhost:8080/TrunkClubService/RetrieveDataUser
  * Properties: GET Request with parameter for the userName. Returns a todo list in JSON format

* Retrieve incomplete todo by user ID 
  * URL:        http://localhost:8080/TrunkClubService/RetrieveInCompleteUserID
  * Properties: GET Request with parameter for the userID. Returns a todo list in JSON format

* Retrieve incomplete todo by user Name 
  * URL:        http://localhost:8080/TrunkClubService/RetrieveInCompleteUser
  * Properties: GET Request with parameter for the userName. Returns a todo list in JSON format

* update a todo as done by using the todo id 
  * URL:        http://localhost:8080/TrunkClubService/SetDone
  * Properties: 
     * PUT Request with input JSON that has a parameter ToDoID for the todo. Returns the updated todo item in JSON 
     * A Parse Exception is thrown in case of non compatible JSON
