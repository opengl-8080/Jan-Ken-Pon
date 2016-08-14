package janken.step4.controller;

import janken.step4.logic.ComputerName;
import janken.step4.logic.Hand;
import janken.step4.logic.HandName;
import janken.step4.logic.HandNumber;
import janken.step4.logic.UserName;
import janken.step4.logic.UserInput;

import java.io.BufferedReader;
import java.io.IOException;

public class JankenController {

    public void execute(UserName user, ComputerName computer, BufferedReader standardInput) throws IOException {
        while (true) {
            this.mainProcess(user, computer, standardInput);
        }
    }

    private void mainProcess(UserName user, ComputerName computer, BufferedReader standardInput) throws IOException {
        System.out.println(
            "[" + HandNumber.ROCK + "]" + HandName.ROCK + "、" +
            "[" + HandNumber.SCISSORS + "]" + HandName.SCISSORS + "、" +
            "[" + HandNumber.PAPER + "]" + HandName.PAPER + "を入力して下さい ⇒ "
        );

        UserInput userInput = new UserInput(standardInput.readLine());

        if (!HandNumber.isValid(userInput.getValue())) {
            return;
        }

        Hand usersHand = HandNumber.of(userInput.toInt()).toHand();
        System.out.println(user + "が出したのは「" + usersHand.getName() + "」です");

        Hand computersHand = HandNumber.random().toHand();
        System.out.println(computer + "が出したのは「" + computersHand.getName() + "」です");

        if (usersHand == computersHand) {
            System.out.println("あいこです。");
            return;
        }

        System.out.println((usersHand.winTo(computersHand) ? user : computer) + "の勝ちです。");
    }
}
