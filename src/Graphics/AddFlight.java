package Graphics;

import Airports.Airport;
import Airports.ProgramData;
import javafx.collections.ObservableList;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * @class AddFlight adding a new flight
 */
public class AddFlight {
    // departure airport
    protected static ComboBox<String> depICAO = new ComboBox<>();
    //destination airport
    protected static ComboBox<String> destICAO = new ComboBox<>();
    // departure date
    protected static DatePicker depDate = new DatePicker();
    // departure time
    protected static TextField depTime = new TextField();
    //destination date
    protected static DatePicker destDate = new DatePicker();
    // destination time
    protected static TextField destTime = new TextField();
    // array flag saves false or true if the check method / methods from class CheckAddingInput
    // had been done
    static final boolean[] flag = {false,false,false,false};
    static Stage stage = new Stage();

    public static void addNewFlight() {

        GridPane gridPane = new GridPane();
        SetStyles.creatWindow("ADDING A NEW FLIGHT", 800,700, stage, gridPane);

        Label dpICAO = SetStyles.createLabels("Please enter departure airport ICAO:", 1,0,
                Paint.valueOf("black"), Font.font("Arial Rounded MT Bold", 22));
        depICAO.setPromptText("Departure airport");
        GridPane.setRowIndex(depICAO, 2);
        GridPane.setColumnIndex(depICAO, 0);
        
        ObservableList<String> list1 = depICAO.getItems();
        for (Airport airport : ProgramData.getAirports()) {
            list1.add(airport.getAirportICAO());
        }
        
        Label dsICAO = SetStyles.createLabels("Please enter destination airport ICAO:", 3,0,
                Paint.valueOf("black"), Font.font("Arial Rounded MT Bold", 22));
        destICAO.setPromptText("Destination airport");
        GridPane.setRowIndex(destICAO, 4);
        GridPane.setColumnIndex(destICAO, 0);
        
        ObservableList<String> list2 = destICAO.getItems();
        for (Airport airport : ProgramData.getAirports()) {
            list2.add(airport.getAirportICAO());
        }

        Label departureDate = SetStyles.createLabels("Please enter departure date: ", 5,0,
                Paint.valueOf("black"), Font.font("Arial Rounded MT Bold", 22));
        GridPane.setRowIndex(depDate,6 );
        GridPane.setColumnIndex(depDate, 0);
        Label departureTime = SetStyles.createLabels("Please enter departure time: ", 7,0,
                Paint.valueOf("black"), Font.font("Arial Rounded MT Bold", 22));
        Label warning = SetStyles.createLabels("please type the time in this form: HH:MM:SS",8,0,
                Paint.valueOf("black"), Font.font("Arial Rounded MT Bold", 14));
        SetStyles.setPosition(depTime,9,0);
        Label destinationDate = SetStyles.createLabels("Please enter destination date: ", 10,0,
               Paint.valueOf("black"), Font.font("Arial Rounded MT Bold", 22));
        GridPane.setRowIndex(destDate,11 );
        GridPane.setColumnIndex(destDate, 0);
        Label destinationTime = SetStyles.createLabels("Please enter destination time: ", 12,0,
                Paint.valueOf("black"), Font.font("Arial Rounded MT Bold", 22));
        Label warning2 = SetStyles.createLabels("please type the time in this form: HH:MM:SS",13,0,
                Paint.valueOf("black"), Font.font("Arial Rounded MT Bold", 14));
        SetStyles.setPosition(destTime,14,0);

        Button okButton = new Button("OK");
        SetStyles.setStyleForButtons(okButton, 26, 18);
        okButton.setOnMouseClicked(event -> {
            if (CheckAddingInput.checkICAO(depICAO,stage)) {
                flag[0] = false;
            } else flag[0] = true;
            if (CheckAddingInput.checkICAO(destICAO,stage)) {
                flag[1] = false;
            } else flag[1] = true;

            if (CheckAddingInput.checkEntrance(destDate,destTime,stage)) {
                flag[2] = false;
            } else flag[2] = true;

            if (CheckAddingInput.checkEntrance(depDate,depTime,stage)) {
                flag[3] = false;
            } else flag[3] = true;
            correctData();
        });

        Button buttonBack = new Button("BACK");
        SetStyles.setStyleForButtons(buttonBack, 26, 20);
        buttonBack.setOnMouseClicked(event -> {
            AddingData.switchWindow((javafx.stage.Stage) buttonBack.getScene().getWindow());
            stage.close();
        });

        gridPane.getChildren().addAll(depICAO, destICAO, destinationDate, depTime, destTime, warning, warning2,
                okButton, dsICAO, dpICAO, destDate,depDate,departureDate,departureTime,destinationTime, buttonBack);
    }

    public static String getDpICAO() {
        return  depICAO.getValue();
    }
    public static String getDsICAO() {
        return  destICAO.getValue();
    }
    public static String getDpDate() {
        return depDate.getValue().toString();
    }
    public static String getDsDate() {
        return destDate.getValue().toString();
    }
    public static String getDpTime() {
        return depTime.getText();
    }
    public static String getDsTime() {
        return destTime.getText();
    }

    // if all flags are true means all data are correct
    // and close stage
    public static void correctData() {
        if (flag[0] && flag[1] && flag[2] && flag[3]) {
            stage.close();
            ProgramData.addFlight();
        }
    }
}
