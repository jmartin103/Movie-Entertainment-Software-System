package mess_0;


/**
 *  DBConnector:
 *  DBConnector handles all connections to a MySQL Database.
 *
 *  @ObjectVariables:
 *  private String dbURL -> URL for MySQL Database :: ie. 107.180.4.111:3306/jkh_TheaterDB
 *  private Connection connection -> DBConnector connection via JDBC
 *  private Statement statement ->
 *  private ResultSet result ->
 *
 */

import java.sql.*;

public class DBConnector {


    private DBLoginData loginData;
    private String dbURL;
    private Connection connection;
    private Statement statement;
    private ResultSet result;

    // Default Constructor
    public DBConnector() {

    }


    // Constructor with login parameters
    public DBConnector(DBLoginData loginData) {
        this.loginData = loginData;
    }

    /*
        setConnection(DBLoginData loginData)
        -> sets connection to MySQL Database via JDBC
        returns true if is connection successful
        else return false
     */

    public boolean setConnection(DBLoginData loginData) {
        try {
            this.connection = DriverManager.getConnection(this.loginData.dbURL, this.loginData.user, this.loginData.pw);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    /*
        setDbURL()
        -> sets (String) dbURL
     */

    public void setDbURL(String url) {
        this.dbURL = "jdbc:mysql://" + url;
    }

    /*
        getDbURL()
        -> returns (String) this.dbURL
     */

    public String getDbURL() {
        return this.dbURL;
    }

    /*
        createStatement()
        -> creates a new statement for DBConnector.
        -> each new DBConnector requires createStatement()
     */

    public void createStatement() {
        try {
            this.statement = this.connection.createStatement();
        } catch (Exception e) {
            System.out.println("Error: createStatement");
        }
    }

    /*
        setResult(String query)
        -> executes query via statement, and passes to result
     */


    public void setResult(String query) {
        try {
            this.result = this.statement.executeQuery(query);
        } catch (Exception e) {
            System.out.println("Error: setResult");
        }
    }

    /*
        getResult()
        -> returns current result (ResultSet)
     */

    public ResultSet getResult() {
        return this.result;
    }


    public DBLoginData getLoginData() {
        return this.loginData;
    }

    // method to retrieve theater info/name
    public TheaterInfo getTheaterInfo(DBLoginData loginData){
        TheaterInfo theaterInfo = new TheaterInfo();

        // first set connection
        try {
            this.connection = DriverManager.getConnection(this.loginData.dbURL, this.loginData.user, this.loginData.pw);
        }
        catch (Exception e) {
            System.out.println("ERROR getting theater info");
        }

        // createStatement
        this.createStatement();

        String theaterInfoQuery = "SELECT theaterName FROM theaterInfo";

        setResult(theaterInfoQuery);

        try {
            while (result.next()) {
              theaterInfo.setTheaterName(result.getString(1));
            }
        }catch(Exception e){

        }

        return theaterInfo;

    }

    //method to check if employeeID exists in Employee table of theater Database
    public boolean checkEmployee(DBLoginData loginData, String empId){
        try{
            this.connection = DriverManager.getConnection(this.loginData.dbURL, this.loginData.user, this.loginData.pw);
        }
        catch (Exception e){
            System.out.println("error connecting: method checkEmployee()");
        }
        this.createStatement();

        String employeeIdQuery = "SELECT * FROM employee where eid =" + "'"+empId+"'";

        setResult(employeeIdQuery);

        try{
            while(result.next()){
                if (result.getString(1).equals(empId)){
                    System.out.println("Employee Found");
                    return true;
                }
            }
        }
        catch (Exception e){
            System.out.println("Error in checkEmployee method, during second try");
        }

        System.out.println("Employee Not Found");
        return false;

    }
}