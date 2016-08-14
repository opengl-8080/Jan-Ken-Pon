package janken.javafx.controller;

import janken.step6.logic.ComputerName;
import janken.step6.logic.Hand;
import janken.step6.logic.HandName;
import janken.step6.logic.UserName;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private final UserName user = new UserName();
    private final ComputerName computer = new ComputerName();

    @FXML
    private Label displayLabel;
    @FXML
    private Button rockButton;
    @FXML
    private Button scissorsButton;
    @FXML
    private Button paperButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.initializeButtonText();
        this.displayLabel.setText("");
    }

    private void initializeButtonText() {
        this.rockButton.setText(HandName.ROCK.toString());
        this.scissorsButton.setText(HandName.SCISSORS.toString());
        this.paperButton.setText(HandName.PAPER.toString());
    }

    @FXML
    public void onClickRockButton() {
        this.onClickButton(Hand.ROCK);
    }

    @FXML
    public void onClickScissorsButton() {
        this.onClickButton(Hand.SCISSORS);
    }

    @FXML
    public void onClickPaperButton() {
        this.onClickButton(Hand.PAPER);
    }

    private void onClickButton(Hand usersHand) {
        Hand computersHand = Hand.random();
        String displayText = this.user + "が出したのは「" + HandName.of(usersHand) + "」です\n" +
                             this.computer + "が出したのは「" + HandName.of(computersHand) + "」です\n";

        if (usersHand == computersHand) {
            displayText += "あいこです";
            this.displayLabel.setText(displayText);
            return;
        }

        displayText += (usersHand.winTo(computersHand) ? user : computer) + "の勝ちです";
        this.displayLabel.setText(displayText);
    }
}
