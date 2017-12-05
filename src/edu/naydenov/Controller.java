package edu.naydenov;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class Controller {
    public Label shift;
    public TextField alphabet;
    public TextArea text;
    public TextArea result;
    private CaesarCipher cipher;

    public Controller() {
        cipher = new CaesarCipher();
    }

    public void onLeftClicked(MouseEvent mouseEvent) {
        cipher.decShift();
        shiftUpdate();
    }

    public void onRightClicked(MouseEvent mouseEvent) {
        cipher.incShift();
        shiftUpdate();
    }

    private void shiftUpdate() {
        shift.setText("Сдвиг: " + cipher.getShift());
    }

    public void onAlphabetChanged(KeyEvent keyEvent) {
        cipher.setAlphabet(alphabet.getText());
    }

    public void onCipherClicked(MouseEvent mouseEvent) {
        result.setText(cipher.getResult());
    }

    public void onTextChanged(KeyEvent keyEvent) {
        cipher.setText(text.getText());
    }
}
