package Graphics;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.layout.CornerRadii;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.CheckBox;

/**
 * @class CheckAddingInput check if the input from the administrator
 * is in the correct form and not null
 */
public class CheckAddingInput {

    public static boolean checkSSN(TextField textField, Stage stage) {
        boolean checkSSN = false;
        if (textField.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Null Data");
            alert.setContentText("You forgot to enter SSN");
            java.util.Optional<javafx.scene.control.ButtonType> result = alert.showAndWait();
            if (result.isPresent() && (result.get() == ButtonType.OK)) {
                alert.close();
                stage.show();
            }
        }
        if (textField.getText().length() != 9) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid Data");
            alert.setContentText("SSN number should have ONLY 9 digits");
            java.util.Optional<ButtonType> result2 = alert.showAndWait();
            if (result2.isPresent() && (result2.get() == javafx.scene.control.ButtonType.OK)) {
                alert.close();
                stage.show();
            }
            return checkSSN = true;
        } else {
           return checkSSN = false;
        }
    }

    public static boolean checkAirport(TextField name, TextField icao,  Stage stage) {
        boolean checkICAO = false;
        if (name.getText().equals("") || icao.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Null Data");
            alert.setContentText("You forgot to enter data for the airport");
            java.util.Optional<javafx.scene.control.ButtonType> result = alert.showAndWait();
            if (result.isPresent() && (result.get() == ButtonType.OK)) {
                alert.close();
                stage.show();
            }
        }
        int count = 0;
        char ch;
        if (icao.getText().length() == 4) {
            for (int i = 0; i < icao.getText().length(); i++) {
                ch = icao.getText().charAt(i);
                if (Character.isUpperCase(ch)) {
                    count++;
                }
            }
            if (count == 4) {
               return checkICAO = true;
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid Data");
            alert.setContentText("The ICAO of the airport should have ONLY 4 CAPITAL LETTERS");
            java.util.Optional<ButtonType> result3 = alert.showAndWait();
            if (result3.isPresent() && (result3.get() == ButtonType.OK)) {
                alert.close();
                stage.show();
            }
        }
        return checkICAO;
    }

    public static boolean checkPersonData(TextField name, TextField lastname, TextField address, TextField phone, Stage stage) {
        boolean personData = false;
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Null Data");
        if (name.getText().equals("") || lastname.getText().equals("") || address.getText().equals("")
              || phone.getText().equals("")) {
            alert.setContentText("You forgot to enter personal data");
            java.util.Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && (result.get() == ButtonType.OK)) {
                alert.close();
                stage.show();
            }
            return personData = true;
        }
        return  personData;
    }

    public static boolean checkID(TextField id, Stage stage) {
        boolean checkid = false;
        if (id.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Null Data");
            alert.setContentText("You forgot to enter ID number");
            java.util.Optional<javafx.scene.control.ButtonType> result = alert.showAndWait();
            if (result.isPresent() && (result.get() == ButtonType.OK)) {
                alert.close();
                stage.show();
            }
            return checkid = true;
        }
        return checkid;
    }

    public static boolean checkLuggage(TextField luggage, Stage stage) {
        boolean checkLuggage = false;
        if ((luggage.getText().equals("YES") || luggage.getText().equals("NO")) && !luggage.getText().equals("")) {
            checkLuggage = true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid Data");
            alert.setContentText("You should type 'YES' OR 'NO'");
            java.util.Optional<ButtonType> result3 = alert.showAndWait();
            if (result3.isPresent() && (result3.get() == ButtonType.OK)) {
                alert.close();
                stage.show();
            }
        }
        return checkLuggage;
    }

    public static boolean checkGate(TextField gate, Stage stage) throws Exception {
        boolean checkGate = false;
        char ch = 0;
        try {
            ch = gate.getText().charAt(0);
        } catch (StringIndexOutOfBoundsException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Null Data");
            alert.setContentText("You forgot to enter gate");
            java.util.Optional<javafx.scene.control.ButtonType> result = alert.showAndWait();
            if (result.isPresent() && (result.get() == ButtonType.OK)) {
                alert.close();
                stage.show();
            }
        }
        if (gate.getText().length() != 1 || !Character.isUpperCase(ch)) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid Data");
            alert.setContentText("The gate should have ONLY 1 CAPITAL LETTERS");
            java.util.Optional<ButtonType> result3 = alert.showAndWait();
            if (result3.isPresent() && (result3.get() == ButtonType.OK)) {
                alert.close();
                stage.show();
            }
            return checkGate = true;
        }
        return checkGate;
    }

    public static boolean checkICAO(ComboBox icao, Stage stage) {
        boolean checkicao = false;
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Null Data");
        if (icao.getValue() == null) {
            alert.setContentText("You forgot to pick airport ICAO");
            java.util.Optional<javafx.scene.control.ButtonType> result = alert.showAndWait();
            if (result.isPresent() && (result.get() == ButtonType.OK)) {
                alert.close();
                stage.show();
            }
            return checkicao = true;
        }
        return checkicao = false;
    }

    public static boolean checkEntrance(DatePicker date,TextField time, Stage stage) {
        boolean checkEntrance = false;
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Null Data");
        if (date.getValue() == null || time.getText().equals("")) {
            alert.setContentText("You forgot to enter date or time");
            java.util.Optional<javafx.scene.control.ButtonType> result = alert.showAndWait();
            if (result.isPresent() && (result.get() == ButtonType.OK)) {
                alert.close();
                stage.show();
            }
            return checkEntrance = true;
        }
        return  checkEntrance;
    }

    public static boolean checkStore(TextField store, Stage stage) {
        boolean checkStore = false;
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Null Data");
        if (store.getText().equals("")) {
            alert.setContentText("You forgot to enter store");
            java.util.Optional<javafx.scene.control.ButtonType> result = alert.showAndWait();
            if (result.isPresent() && (result.get() == javafx.scene.control.ButtonType.OK)) {
                alert.close();
                stage.show();
            }
            return checkStore = true;
        }
        return checkStore;
    }

    public static boolean checkStuff(ComboBox stuff, Stage stage) {
        boolean checkStuff = false;
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Null Data");
        if (stuff.getValue() == null) {
            alert.setContentText("You forgot to pick employee type ");
            java.util.Optional<javafx.scene.control.ButtonType> result = alert.showAndWait();
            if (result.isPresent() && (result.get() == ButtonType.OK)) {
                alert.close();
                stage.show();
            }
            return checkStuff = true;
        }
        return checkStuff;
    }

    public static boolean checkScheduleDate(Stage stage, CheckBox cb1,CheckBox cb2, CheckBox cb3, CheckBox cb4, CheckBox cb5,
                                         CheckBox cb6, CheckBox cb7 ) {
        boolean checkdate = false;
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Null Data");
        if (!cb1.isSelected() && !cb2.isSelected() && !cb3.isSelected() && !cb4.isSelected() && !cb5.isSelected() &&
                !cb6.isSelected() && !cb7.isSelected()) {
            alert.setContentText("You forgot to pick date");
            java.util.Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && (result.get() == ButtonType.OK)) {
                alert.close();
                stage.show();
            }
            return checkdate = true;
        }
        return checkdate;
    }

    public static boolean checkScheduleTime(Stage stage, TextField t1, TextField t2, TextField t3, TextField t4, TextField t5,
                                         TextField t6,TextField t7 ) {
        boolean checktime = false;
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Null Data");
        if (t1.getText().equals("") && t2.getText().equals("") && t3.getText().equals("") && t4.getText().equals("") &&
                t5.getText().equals("") && t6.getText().equals("") && t7.getText().equals("")) {
            alert.setContentText("You forgot to enter time");
            java.util.Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && (result.get() == ButtonType.OK)) {
                alert.close();
                stage.show();
            }
            return checktime = true;
        }
        return checktime;
    }


    /**
     * @param situation defines if the addition have been completed
     * show up suitable message for the administrator
     */
    public static void message(boolean situation) {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        Stage stage = new Stage();
        BackgroundFill background_fill = new BackgroundFill(Color.FLORALWHITE, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        gridPane.setBackground(background);
        stage.setScene(new Scene(gridPane, 800, 400));
        Label pressEXIT = SetStyles.createLabels("Press X to the top right of the window to leave the application ",
                4, 0,
                Paint.valueOf("black"), Font.font("Arial Rounded MT Bold", 18));

        if (situation) {
            stage.setTitle("COMPLETED");
            Label message = SetStyles.createLabels("The add had successfully completed! ",
                        3, 0,
                        Paint.valueOf("black"), Font.font("Arial Rounded MT Bold", 22));
                gridPane.getChildren().addAll(message, pressEXIT);

        } else {
            stage.setTitle("Error");
            Label message = SetStyles.createLabels("Seems that something went wrong! ",
                    3, 0,
                    Paint.valueOf("black"), Font.font("Arial Rounded MT Bold", 22));
            gridPane.getChildren().addAll(message, pressEXIT);

        }
        stage.show();
    }

}






