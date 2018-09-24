package mess_0;


/*
    DBLoginData:
    Object that holds Theater Database Login information.  The DBLogin is used
    as a parameter in the Session constructor to complete the connection to the MySQL database.
 */

public class DBLoginData {

    String user; // = "krishermstadDBA";
    String pw;   // =  "password";
    String dbURL; // "jdbc:mysql://"+ url;

    public DBLoginData(String user, String pw, String url){
        this.user = user;
        this.pw = pw;
        this.dbURL = "jdbc:mysql://"+ url;
    }

}