package mess_0;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class EmpLoginScene {

    // grid holds all Scene elements
    GridPane grid = new GridPane();
    // Scene that holds grid
    Scene scene = new Scene(grid, 440, 600);

    // place holder for theater name, should never show this text used below.
    Text theaterName = new Text("TheaterName goes Here");

    // header
    Text empLoginHeader = new Text("Employee Log-In:");
    TextField employeeLoginField = new TextField();
    Button backBtn = new Button("Back to Theater DB Login");

    // status text to show if employee login fails
    final Text statusText = new Text();


    // number pad for employee id field
    Button btn0 = new Button("0");
    Button btn1 = new Button("1");
    Button btn2 = new Button("2");
    Button btn3 = new Button("3");
    Button btn4 = new Button("4");
    Button btn5 = new Button("5");
    Button btn6 = new Button("6");
    Button btn7 = new Button("7");
    Button btn8 = new Button("8");
    Button btn9 = new Button("9");

    Button submitEmpBtn = new Button("Sign-In");
    Button resetEmpBtn = new Button("Reset");


    public EmpLoginScene(){
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        grid.add(theaterName, 0, 0, 2, 1);
        grid.add(empLoginHeader, 0, 1, 2, 1);
        grid.add(employeeLoginField, 0, 2 ,2 , 1);

        grid.add(btn1, 0, 3);
        btn1.setPrefSize(100, 100);

        grid.add(btn2, 1, 3);
        btn2.setPrefSize(100, 100);


        grid.add(btn3, 2, 3);
        btn3.setPrefSize(100, 100);

        grid.add(btn4, 0, 4);
        btn4.setPrefSize(100, 100);

        grid.add(btn5, 1, 4);
        btn5.setPrefSize(100, 100);

        grid.add(btn6, 2, 4);
        btn6.setPrefSize(100, 100);

        grid.add(btn7, 0, 5);
        btn7.setPrefSize(100, 100);

        grid.add(btn8, 1, 5);
        btn8.setPrefSize(100, 100);

        grid.add(btn9, 2, 5);
        btn9.setPrefSize(100, 100);

        grid.add(btn0, 1, 6);
        btn0.setPrefSize(100, 100);

        grid.add(submitEmpBtn, 0, 7);
        submitEmpBtn.setPrefSize(100, 100);

        grid.add(resetEmpBtn, 2, 7);
        resetEmpBtn.setPrefSize(100, 100);

        grid.add(backBtn, 0, 8, 2, 1);

        grid.add(statusText, 0, 9, 2, 1);

        resetEmpBtn.setOnAction(e-> employeeLoginField.setText(""));

        // handlers for number buttons
        btn1.setOnAction(e-> employeeLoginField.setText(employeeLoginField.getText()+ "1"));
        btn2.setOnAction(e-> employeeLoginField.setText(employeeLoginField.getText()+ "2"));
        btn3.setOnAction(e-> employeeLoginField.setText(employeeLoginField.getText()+ "3"));
        btn4.setOnAction(e-> employeeLoginField.setText(employeeLoginField.getText()+ "4"));
        btn5.setOnAction(e-> employeeLoginField.setText(employeeLoginField.getText()+ "5"));
        btn6.setOnAction(e-> employeeLoginField.setText(employeeLoginField.getText()+ "6"));
        btn7.setOnAction(e-> employeeLoginField.setText(employeeLoginField.getText()+ "7"));
        btn8.setOnAction(e-> employeeLoginField.setText(employeeLoginField.getText()+ "8"));
        btn9.setOnAction(e-> employeeLoginField.setText(employeeLoginField.getText()+ "9"));
        btn0.setOnAction(e-> employeeLoginField.setText(employeeLoginField.getText()+ "0"));

    }

}