package mess_0;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {


    // TheaterInfo object that holds basic theater info.
    TheaterInfo theaterInfo;

    // currentEmpId => current employee logged in
    String currentEmpId;

    // JDBC database connector
    DBConnector dbc;

    // login data
    DBLoginData loginData;

    @Override
    public void start(Stage primaryStage) throws Exception {

        // all scenes held within Scenes object.
        Scenes scenes = new Scenes();
        primaryStage.setTitle("MESS");

        // set first scene, Theater Database Login.
        primaryStage.setScene(scenes.scene1.scene);
        primaryStage.show();



        /////////////////////////////////////////////////////////////////////////////
        //SCENE 1: Theater Log-in Methods ///////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////

        // Sign-in submitBtn
        scenes.scene1.submitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (scenes.scene1.dbUrlTextField.getText().length() < 1
                        || scenes.scene1.adminTextField.getText().length() < 1 || scenes.scene1.pwField.getText().length() < 1){
                    scenes.scene1.statusText.setFill(Color.DARKRED);
                    scenes.scene1.statusText.setText("ERROR: Check URL, Admin, or Password.");
                }
                else{
                    loginData = new DBLoginData(scenes.scene1.adminTextField.getText(),
                            scenes.scene1.pwField.getText(), scenes.scene1.dbUrlTextField.getText());

                    dbc = new DBConnector(loginData);

                    boolean isConnected = dbc.setConnection(dbc.getLoginData());
                    if (isConnected==true){
                        scenes.scene1.statusText.setText("Connection Successful!");
                        try{
                            // get theaterInfo from theater database
                            theaterInfo = dbc.getTheaterInfo(loginData);

                            // set theaterName tag in scene 2 before changing to scene 2
                            scenes.scene2.theaterName.setText(theaterInfo.getTheaterName());


                            primaryStage.setScene(scenes.scene2.scene);
                        }
                        catch(Exception e){
                            System.out.println("Error while changing from scenes.scene1 to empScene");
                        }
                    }
                    else{
                        scenes.scene1.statusText.setText("Unable To Connect. Try Again.");
                    }
                }
            }
        });

        // Reset Button handler
        // resets all fields in DBLoginScene
        scenes.scene1.resetBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                scenes.scene1.dbUrlTextField.setText("");
                scenes.scene1.adminTextField.setText("");
                scenes.scene1.pwField.setText("");
            }
        });


        //////////////////////////////////////////////////////////////////////////////
        //SCENE 2: Employee Log-in Methods ///////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////

        // Sign In Handler for EmpLoginScene
        scenes.scene2.submitEmpBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                currentEmpId = scenes.scene2.employeeLoginField.getText();

                boolean isEmployee = dbc.checkEmployee(loginData, currentEmpId);

                if (isEmployee){
                    primaryStage.setScene(scenes.scene3.scene);
                }
                else{
                    scenes.scene2.statusText.setText("Invalid Employee ID.");
                }
                // primaryStage.setScene(scenes.scene3.scene);
                // System.out.println("Employee Logged In");
            }
        });



        // Reset Button Handler
        // resets all fields in EmpLoginScene
        scenes.scene2.resetEmpBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                scenes.scene2.employeeLoginField.setText("");
            }
        });

        // BACK button Handler
        // sets scene to previous scene, Scene1 Theater Database Login
        scenes.scene2.backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                // first, reset the EmployeeLogin field in Scene 2
                scenes.scene2.employeeLoginField.setText("");

                // then, reset all fields in scene1
                scenes.scene1.dbUrlTextField.setText("");
                scenes.scene1.adminTextField.setText("");
                scenes.scene1.pwField.setText("");
                scenes.scene1.statusText.setText("");


                // finally, set scene back to scene1
                primaryStage.setScene(scenes.scene1.scene);
            }
        });

    }


    public static void main(String[] args) {
        launch(args);
    }

}
