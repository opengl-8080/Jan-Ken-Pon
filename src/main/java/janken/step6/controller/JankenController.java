package janken.step6.controller;

import janken.step6.logic.ComputerName;
import janken.step6.logic.Hand;
import janken.step6.logic.HandName;
import janken.step6.logic.HandNumber;
import janken.step6.logic.UserName;
import janken.step6.logic.UserInput;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * {@code logic} パッケージ以下のクラスを制御することでじゃんけんプログラムのフローを実現するコントローラ.
 */
public class JankenController {

    /**
     * じゃんけんを開始する.
     * @param user ユーザーの主語
     * @param computer コンピュータの主語
     * @param standardInput 標準入力をラップした {@link BufferedReader}
     * @throws IOException 入力例外が発生した場合.
     */
    public void execute(UserName user, ComputerName computer, BufferedReader standardInput) throws IOException {
        while (true) {
            this.mainProcess(user, computer, standardInput);
        }
    }

    /**
     * じゃんけんのメイン処理.
     * @param user ユーザーの主語
     * @param computer コンピュータの主語
     * @param standardInput 標準入力をラップした {@link BufferedReader}
     * @throws IOException 入力例外が発生した場合.
     */
    private void mainProcess(UserName user, ComputerName computer, BufferedReader standardInput) throws IOException {
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

        Hand computersHand = Hand.random();
        System.out.println(computer + "が出したのは「" + HandName.of(computersHand) + "」です");

        if (usersHand == computersHand) {
            System.out.println("あいこです。");
            return;
        }

        System.out.println((usersHand.winTo(computersHand) ? user : computer) + "の勝ちです。");
    }
}
