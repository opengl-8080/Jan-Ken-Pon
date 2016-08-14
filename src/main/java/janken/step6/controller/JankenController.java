package janken.step6.controller;

import janken.step6.logic.ComputerSubject;
import janken.step6.logic.Hand;
import janken.step6.logic.HandName;
import janken.step6.logic.HandNumber;
import janken.step6.logic.UserSubject;
import janken.step6.logic.UserInput;

import java.io.BufferedReader;
import java.io.IOException;

public class JankenController {

    public void execute(UserSubject user, ComputerSubject computer, BufferedReader standardInput) throws IOException {
        while (true) {
            this.mainProcess(user, computer, standardInput);
        }
    }

    private void mainProcess(UserSubject user, ComputerSubject computer, BufferedReader standardInput) throws IOException {
        System.out.println(
            "[" + HandNumber.ROCK + "]" + HandName.ROCK + "、" +
            "[" + HandNumber.SCISSORS + "]" + HandName.SCISSORS + "、" +
            "[" + HandNumber.PAPER + "]" + HandName.PAPER + "を入力して下さい ⇒ "
        );

        UserInput userInput = new UserInput(standardInput.readLine());

        if (!userInput.validate(HandNumber::isValid)) {
            return;
        }

        Hand usersHand = HandNumber.toHand(userInput.toInt());
        System.out.println(user + "が出したのは「" + HandName.of(usersHand) + "」です");

        Hand computersHand = HandNumber.randomHand();
        System.out.println(computer + "が出したのは「" + HandName.of(computersHand) + "」です");

        if (usersHand == computersHand) {
            System.out.println("あいこです。");
            return;
        }

        System.out.println((usersHand.winTo(computersHand) ? user : computer) + "の勝ちです。");
    }
}
