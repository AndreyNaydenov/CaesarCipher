package edu.naydenov;

import javafx.fxml.FXML;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;

public class Controller {
    public ComboBox<String> shift;
    public ComboBox<String> alphabet;
    public TextArea input;
    public TextArea output;
    private CaesarCipher cipher;

    public Controller() {
        cipher = new CaesarCipher();
    }

    @FXML
    private void initialize() {
        alphabet.setItems(FXCollections.observableArrayList("English", "Russian"));
        alphabet.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                cipher.setAlphabet(newValue);
                updateOutput();
            }
        });
        alphabet.setValue("English");

        shift.setItems(FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33"));
        shift.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                cipher.setShift(Integer.parseInt(newValue));
                updateOutput();
            }
        });
        shift.setValue("0");

        input.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                onInputChanged();
                updateOutput();
            }
        });
    }

    private void updateOutput() {
        String ciphertext = cipher.getResult();
        output.setText(ciphertext);
    }

    private void onInputChanged() {
        cipher.setText(input.getText());
    }
}
