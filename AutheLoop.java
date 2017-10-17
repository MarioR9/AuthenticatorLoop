import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Pair;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

/**
 *Mario Rodriguez
 *
 *This Program will authenticate Username and Password, After 3 Attempts it will close; if Username is incorrect message will display "Invalid UserName".
 * if username and Password are correct GroupSize program will start.
 *
 */

public class AutheLoop extends Application {
    @Override

    public void start(Stage primaryStage) {
        int MaxAttempts = 3;

//Loop Starts do..while.
        do {
            String name = "Mario";
            String pass = "Pass";

            Dialog<Pair<String, String>> dialog = new Dialog<>();
            dialog.setTitle("Authenticator");
            dialog.setHeaderText("Enter Username and Password");
	    dialog.setGraphic(new ImageView(this.getClass().getResource("Trooper.png").toString()));

            Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image(this.getClass().getResource("Alliance.png").toString()));

            ButtonType loginButtonType = new ButtonType("Login", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(20, 150, 10, 10));

            TextField username = new TextField();
            username.setPromptText("Username");
            PasswordField password = new PasswordField();
            password.setPromptText("Password");

            grid.add(new Label("Username:"), 0, 0);
            grid.add(username, 1, 0);
            grid.add(new Label("Password:"), 0, 1);
            grid.add(password, 1, 1);
            Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
            loginButton.setDisable(true);

            username.textProperty().addListener((observable, oldValue, newValue) -> {
                loginButton.setDisable(newValue.trim().isEmpty());
            });

            dialog.getDialogPane().setContent(grid);
            Platform.runLater(() -> username.requestFocus());
            dialog.setResultConverter(dialogButton -> {
                if (dialogButton == loginButtonType) {
                    return new Pair<>(username.getText(), password.getText());
                } else {

                    System.exit(0);
                    return null;
                }
            });
            dialog.showAndWait();

            if (!username.getText().equals(name) && password.getText().equals(pass) ) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("USERNAME ERROR");
                alert.setHeaderText(null);
                alert.setContentText("Invalid UserName");

                Stage stage1 = (Stage) alert.getDialogPane().getScene().getWindow();
                stage1.getIcons().add(new Image(this.getClass().getResource("Alliance.png").toString()));

                alert.showAndWait();
            }

            if (username.getText().equals(name) && password.getText().equals(pass)) {


               int GroupSize = 0;

        TextInputDialog dialog2 = new TextInputDialog("Ex:1...");
        dialog2.setTitle("Enter Numbers");
        dialog2.setHeaderText("Number of People");
        dialog2.setContentText("Enter here --> ");
        dialog2.setGraphic(new ImageView(this.getClass().getResource("People.png").toString()));

        Stage stagedialog = (Stage) dialog2.getDialogPane().getScene().getWindow();
        stagedialog.getIcons().add(new Image(this.getClass().getResource("Alliance.png").toString()));

        dialog2.showAndWait();

        int NumOfPeople = Integer.parseInt(dialog2.getResult());

        if (NumOfPeople > 10) {
            GroupSize = NumOfPeople / 2;

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Number Of People");
            alert.setHeaderText(null);
            alert.setContentText("Group Size is grater than 10 people " + "\n" + "Number of People is: " + NumOfPeople + "\n" + "Group Size " + GroupSize);

            Stage stage1 = (Stage) alert.getDialogPane().getScene().getWindow();
            stage1.getIcons().add(new Image(this.getClass().getResource("Alliance.png").toString()));

            alert.showAndWait();

        } else if (NumOfPeople > 3 && NumOfPeople < 10) {
            GroupSize = NumOfPeople / 3;

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Number Of People");
            alert.setHeaderText(null);
            alert.setContentText("Group Size is between 3 and 10 people" + "\n" + "Number of People is: " + NumOfPeople + "\n" + "Group Size " + GroupSize);

            Stage stage2 = (Stage) alert.getDialogPane().getScene().getWindow();
            stage2.getIcons().add(new Image(this.getClass().getResource("Alliance.png").toString()));

            alert.showAndWait();

        } else {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Number Of People");
            alert.setHeaderText(null);
            alert.setContentText("The number of people has to be at least 3." + "\n" + "Number of People " + NumOfPeople + " Group Size " + GroupSize);

            Stage stage3 = (Stage) alert.getDialogPane().getScene().getWindow();
            stage3.getIcons().add(new Image(this.getClass().getResource("Alliance.png").toString()));

            alert.showAndWait();
            
            

        }

//TeamSize
	

        int TeamSize = 0;

        TextInputDialog dialogTeam = new TextInputDialog("Ex:1...");
        dialogTeam.setTitle("Enter Numbers");
        dialogTeam.setHeaderText("Number of Players");
        dialogTeam.setContentText("Enter here --> ");
        dialogTeam.setGraphic(new ImageView(this.getClass().getResource("Player.png").toString()));

	 Stage stageTeam = (Stage) dialogTeam.getDialogPane().getScene().getWindow();
            stageTeam.getIcons().add(new Image(this.getClass().getResource("Alliance.png").toString()));

        dialogTeam.showAndWait();

        int NumOfPlayers = Integer.parseInt(dialogTeam.getResult());

        if (NumOfPlayers >11 && NumOfPlayers <55) {
            TeamSize = NumOfPlayers / 11;

            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Number Of People");
            alert1.setHeaderText(null);
            alert1.setContentText("Team Size is between 11 and 55 Players " + "\n" + "Number of Players is: " + NumOfPlayers + "\n" + "Team Size " + TeamSize);

            Stage stage4 = (Stage) alert1.getDialogPane().getScene().getWindow();
            stage4.getIcons().add(new Image(this.getClass().getResource("Alliance.png").toString()));

            alert1.showAndWait();
 	    System.exit(0);

        } else if (NumOfPlayers > 55) {
            TeamSize = 1;

            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Number Of Players");
            alert1.setHeaderText(null);
            alert1.setContentText("Team Size is Greater than 55" + "\n" + "Number of Players is: " + NumOfPlayers + "\n" + "Team Size " + TeamSize);

            Stage stage5 = (Stage) alert1.getDialogPane().getScene().getWindow();
            stage5.getIcons().add(new Image(this.getClass().getResource("Alliance.png").toString()));

            alert1.showAndWait();
 	    System.exit(0);

        } else {

            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Number Of Players");
            alert1.setHeaderText(null);
            alert1.setContentText("The number of Players has to be at least 3." + "\n" + "Number of Players is: " + NumOfPlayers + "Team Size " + TeamSize);

            Stage stage6 = (Stage) alert1.getDialogPane().getScene().getWindow();
            stage6.getIcons().add(new Image(this.getClass().getResource("Alliance.png").toString()));

            alert1.showAndWait();


            System.exit(0);
        }

            } else {

//MaxAttempts decrement by 1 everytime username and password is enver wrong.Message alert display.
               
		 MaxAttempts--;


                if (MaxAttempts == 0) {
                    Alert alert2 = new Alert(Alert.AlertType.ERROR);
                    alert2.setTitle("Account Lock");
                    alert2.setHeaderText("*Account Lock*");
                    alert2.setContentText("Contact Administrator");
                    Stage stage3 = (Stage) alert2.getDialogPane().getScene().getWindow();
                    stage3.getIcons().add(new Image(this.getClass().getResource("Alliance.png").toString()));
                    alert2.showAndWait();
                }
            }
        }while (MaxAttempts != 0) ;
    }
}
