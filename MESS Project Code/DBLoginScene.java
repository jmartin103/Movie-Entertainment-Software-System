package mess_0;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class DBLoginScene {

    // grid holds all Scene elements
    GridPane grid = new GridPane();

    // title for login form
    Text title = new Text("M.E.S.S. Movie Entertainment Software System");
    Text dbLoginHeader = new Text("Theater Log-In");

    // theaterDB login field
    Label dbUrlLbl = new Label("Database URL:");
    TextField dbUrlTextField = new TextField();

    // admin login field
    Label adminLbl = new Label("Admin:");
    TextField adminTextField = new TextField();

    // password login field
    Label passwordLbl = new Label("Password:");
    PasswordField pwField = new PasswordField();

    //button to submit login
    Button submitBtn = new Button("Sign In");

    // button to reset fields in scene
    Button resetBtn = new Button("Reset");

    // statusText - displays "Connected" or "Unable to Connect"
    final Text statusText = new Text();

    // Scene that holds grid
    Scene scene = new Scene(grid, 800, 300);

    // DBLoginScene constructor
    public DBLoginScene(){
        // basic alignment and gap settings
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // set font for title and dbLoginHeader
        title.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 25));
        dbLoginHeader.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));

        // add elements to grid
        grid.add(title, 0, 0 , 2, 1);
        grid.add(dbLoginHeader, 0, 1, 2, 1);

        grid.add(dbUrlLbl, 0, 2);
        grid.add(dbUrlTextField, 1, 2);

        grid.add(adminLbl, 0, 3);
        grid.add(adminTextField, 1, 3);

        grid.add(passwordLbl, 0, 4);
        grid.add(pwField, 1, 4);

        grid.add(submitBtn, 0, 7);
        grid.add(resetBtn, 1, 7);

        grid.add(statusText, 0, 8, 2, 1);

    }

}

