package Graphics;

import Airports.ProgramData;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.control.CheckBox;
/**
 * @class AddAirportStuff adding a new employee
 * (Store Stuff, Gate Stuff, CheckIn Stuff)
 */
public class AddAirportStuff {
    protected static TextField textAreaSSN = new TextField();
    protected static TextField textAreaName = new TextField();
    protected static TextField textAreaLastName = new TextField();
    protected static TextField textAreaAddress = new TextField();
    protected static TextField textAreaPhone = new TextField();
    protected static TextField textAreaGate = new TextField();
    protected static TextField textAreaStore = new TextField();
    protected static ComboBox<String> combo3 = new ComboBox<>();
    protected static ComboBox<String> icao = new ComboBox<>();
    protected static TextField m = new TextField();
    protected static TextField tu = new TextField();
    protected static TextField w = new TextField();
    protected static TextField th = new TextField();
    protected static TextField f = new TextField();
    protected static TextField st = new TextField();
    protected static TextField sn = new TextField();

    // array flag saves false or true if the check method / methods from class CheckAddingInput
    // had been done
    static final boolean[] flag = {false,false,false,false,false,false,false,false};
    static Stage stage = new Stage();

    public static void newAirportStuff() {
        GridPane gridPane = new GridPane();
        SetStyles.creatWindow("ADDING A NEW AIRPORT STUFF", 1700,1000, stage, gridPane);

        Label ssn = SetStyles.createLabels("Please enter the SSN number of the airport stuff member:", 0,0,
                Paint.valueOf("black"), Font.font("Arial Rounded MT Bold", 22));
        SetStyles.setPosition(textAreaSSN,1,0);
        Label name = SetStyles.createLabels("Please enter the First Name of the airport stuff member:", 2,0,
                Paint.valueOf("black"), Font.font("Arial Rounded MT Bold", 22));
        SetStyles.setPosition(textAreaName,3,0);
        Label lastName = SetStyles.createLabels("Please enter the Last Name of the airport stuff member:", 4,0,
                Paint.valueOf("black"), Font.font("Arial Rounded MT Bold", 22));
        SetStyles.setPosition(textAreaLastName,5,0);
        Label address = SetStyles.createLabels("Please enter the address of the airport stuff member:", 6,0,
                Paint.valueOf("black"), Font.font("Arial Rounded MT Bold", 22));
        SetStyles.setPosition(textAreaAddress,7,0);
        Label phone = SetStyles.createLabels("Please enter the phone number of the airport stuff member:", 8,0,
                Paint.valueOf("black"), Font.font("Arial Rounded MT Bold", 22));
        SetStyles.setPosition(textAreaPhone,9,0);
        Label labelTypeOfEmployee = SetStyles.createLabels("Please enter the type of employee:", 10,0,
                Paint.valueOf("black"), Font.font("Arial Rounded MT Bold", 22));
        combo3.setPromptText("Employee Type");
        GridPane.setRowIndex(combo3, 11);
        GridPane.setColumnIndex(combo3, 0);
        javafx.collections.ObservableList<String> list3 = combo3.getItems();
        list3.add("Store Stuff");
        list3.add("Gate Stuff");
        list3.add("CheckIn Stuff");
        Label gate = SetStyles.createLabels("Please enter the working gate of the airport stuff member:", 12,0,
                Paint.valueOf("black"), Font.font("Arial Rounded MT Bold", 22));
        SetStyles.setPosition(textAreaGate,13,0);
        Label store = SetStyles.createLabels("Please enter the working store of the airport stuff member:", 14,0,
                Paint.valueOf("black"), Font.font("Arial Rounded MT Bold", 22));
        SetStyles.setPosition(textAreaStore,15,0);
        Label airportcode = SetStyles.createLabels("Please pick airport ICAO:", 16,0,
                Paint.valueOf("black"), Font.font("Arial Rounded MT Bold", 22));
        icao.setPromptText("Airport ICAO");
        GridPane.setRowIndex(icao, 17);
        GridPane.setColumnIndex(icao, 0);
        
        ObservableList<String> list = icao.getItems();
        for (Airports.Airport airport : ProgramData.getAirports()) {
            list.add(airport.getAirportICAO());
        }

        Label schedule = SetStyles.createLabels("Please pick days and start time for working schedule: ",0,
                3, Paint.valueOf("black"), Font.font("Arial Rounded MT Bold", 22));
        Label warning = SetStyles.createLabels("please type time in this form: HH:MM and if you have a day off type NULL",1,3,
                Paint.valueOf("black"), Font.font("Arial Rounded MT Bold", 14));
        CheckBox monday = SetStyles.createCheckBox("Monday",2, 3);
        CheckBox tuesday = SetStyles.createCheckBox("Tuesday",3,3);
        CheckBox wednesday = SetStyles.createCheckBox("Wednesday",4,3);
        CheckBox thursday = SetStyles.createCheckBox("Thursday",5,3);
        CheckBox friday = SetStyles.createCheckBox("Friday",6,3);
        CheckBox saturday = SetStyles.createCheckBox("Saturday",7,3);
        CheckBox sunday = SetStyles.createCheckBox("Sunday",8,3);

        SetStyles.setPosition(m,2,4);
        SetStyles.setPosition(tu,3,4);
        SetStyles.setPosition(w,4,4);
        SetStyles.setPosition(th,5,4);
        SetStyles.setPosition(f,6,4);
        SetStyles.setPosition(st,7,4);
        SetStyles.setPosition(sn,8,4);
        m.setDisable(true);
        tu.setDisable(true);
        w.setDisable(true);
        th.setDisable(true);
        f.setDisable(true);
        st.setDisable(true);
        sn.setDisable(true);

        monday.setOnAction(event -> {
            if (monday.isSelected()) {
                m.setDisable(false);
            } else m.setDisable(true);
        });
        tuesday.setOnAction(event -> {
            if (tuesday.isSelected()) {
                 tu.setDisable(false);
            } else tu.setDisable(true);
        });
        wednesday.setOnAction(event -> {
            if (wednesday.isSelected()) {
                w.setDisable(false);
            } else w.setDisable(true);
        });
        thursday.setOnAction(event -> {
            if (thursday.isSelected()) {
                th.setDisable(false);
            } else th.setDisable(true);
        });
        friday.setOnAction(event -> {
            if (friday.isSelected()) {
                f.setDisable(false);
            } else f.setDisable(true);
        });
        saturday.setOnAction(event -> {
            if (saturday.isSelected()) {
                st.setDisable(false);
            } else st.setDisable(true);
        });
        sunday.setOnAction(event -> {
            if (sunday.isSelected()) {
                sn.setDisable(false);
            } else sn.setDisable(true);
        });


        combo3.setOnAction(event -> {
            switch (combo3.getValue()) {
                case "Store Stuff":
                    combo3.setDisable(false);
                    textAreaGate.setDisable(true);
                    textAreaStore.setDisable(false);
                    break;

                case "Gate Stuff":
                    combo3.setDisable(false);
                    textAreaStore.setDisable(true);
                    textAreaGate.setDisable(false);
                    break;

                case "CheckIn Stuff":
                    combo3.setDisable(false);
                    textAreaGate.setDisable(true);
                    textAreaStore.setDisable(true);
                    break;
            }
        });



        Button okButton = new Button("OK");
        SetStyles.setStyleForButtons(okButton, 30, 4);
        okButton.setOnMouseClicked(event -> {
            if (CheckAddingInput.checkSSN(textAreaSSN, stage)) {
                flag[0] = false;
            } else flag[0] = true;

            if (CheckAddingInput.checkPersonData(textAreaName,textAreaLastName,textAreaAddress,textAreaPhone,stage)) {
               flag[1] = false;
            } else flag[1] = true;

            if (CheckAddingInput.checkICAO(icao,stage)) {
                flag[2] = false;
            } else flag[2] = true;

            if (CheckAddingInput.checkScheduleDate(stage,monday,tuesday,wednesday,thursday,friday,saturday,sunday)) {
                flag[3] = false;
            } else flag[3] = true;

            if (CheckAddingInput.checkScheduleTime(stage,m,tu,w,th,f,st,sn)) {
                flag[4] = false;
            } else flag[4] = true;

            if(CheckAddingInput.checkStuff(combo3,stage)) {
                flag[5] = false;
            } else flag[5] = true;

            if (combo3.getValue().equals("Store Stuff")) {
                flag[6] = false;
                if (CheckAddingInput.checkStore(textAreaStore,stage)) {
                    flag[7] = false;
                } else {
                    flag[7] = true;
                }
            } else if (combo3.getValue().equals("Gate Stuff")) {
                flag[7] = false;
                try {
                    if (CheckAddingInput.checkGate(textAreaGate, stage)) {
                        flag[6] = false;
                    } else flag[6] = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {
                flag[6] = false;
                flag[7] = false;
            }
            correctData();
        });

        Button buttonBack = new Button("BACK");
        SetStyles.setStyleForButtons(buttonBack, 30, 6);
        buttonBack.setOnMouseClicked(event -> {
            AddingData.switchWindow((javafx.stage.Stage) buttonBack.getScene().getWindow());
            stage.close();
        });

        gridPane.getChildren().addAll(ssn, textAreaSSN, name, textAreaName, lastName, textAreaLastName, address,
                textAreaAddress, phone, textAreaPhone, labelTypeOfEmployee , combo3, gate, textAreaGate,
                store , textAreaStore,icao,airportcode, schedule, monday, tuesday, wednesday, thursday, friday,
                saturday, sunday, m, tu, w, th, f, st, sn, warning,okButton,buttonBack );
    }

    public static String getSSN() {
        return textAreaSSN.getText(); 
    }
    public static String getName() {
        return textAreaName.getText();
    }
    public static String getLastName() {
        return textAreaLastName.getText();
    }
    public static String getAddress() {
        return textAreaAddress.getText();
    }
    public static String getPhone() {
        return textAreaPhone.getText();
    }
    public static String getICAO() {
        return icao.getValue();
    }
    public static String getStore() {
        return textAreaStore.getText();
    }
    public static String getGate() {
        return textAreaGate.getText();
    }

    public static String getM() {
        return m.getText();
    }

    public static String getTu() {
        return tu.getText();
    }

    public static String getW() {
        return w.getText();
    }

    public static String getTh() {
        return th.getText();
    }

    public static String getF() {
        return f.getText();
    }

    public static String getSt() {
        return st.getText();
    }

    public static String getSn() {
        return sn.getText();
    }



    // if all flags are true means all data are correct
    // and close stage
    public static void correctData() {
        if (flag[0] && flag[1] && flag[2] && flag[3] && flag[4] && flag[5]) {
            stage.close();
            if (flag[7] && !flag[6]) {
                ProgramData.addStoreStuff();
            } else if (flag[6] && !flag[7]) {
                ProgramData.addGateStuff();
            } else {
                ProgramData.addCheckInStuff();
            }
        }
    }
}
