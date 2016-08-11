package janken.step4;

import janken.JankenGame;
import janken.step4.logic.Computer;
import janken.step4.logic.Hand;
import janken.step4.logic.HandName;
import janken.step4.logic.HandNumber;
import janken.step4.logic.User;
import janken.step4.logic.UserInput;
import janken.step4.ui.Console;

import java.util.Random;

/**
 * 第４ステップ、「すべてのエンティティを小さくすること」を適用.
 */
public class Step4 implements JankenGame {
    /**ユーザー*/
    private final User user = new User();
    /**コンピュータ*/
    private final Computer computer = new Computer(new Random(System.currentTimeMillis()));
    /**コンソール*/
    private final Console console = new Console(System.in, System.out);

    /**
     * じゃんけんプログラムを開始する.
     */
    @Override
    public void execute() {
        while (true) {
            this.mainProcess();
        }
    }

    /**
     * メインのじゃんけん処理.
     */
    private void mainProcess() {
        this.console.println(
            "[" + HandNumber.ROCK + "]" + HandName.ROCK + "、" +
            "[" + HandNumber.SCISSORS + "]" + HandName.SCISSORS + "、" +
            "[" + HandNumber.PAPER + "]" + HandName.PAPER + "を入力して下さい ⇒ "
        );

        UserInput userInput = this.console.readUserInput();

        if (!HandNumber.isValid(userInput.getValue())) {
            return;
        }

        Hand usersHand = HandNumber.toHand(userInput.toInt());
        this.console.println(user.getSubject() + "が出したのは「" + HandName.toHandName(usersHand) + "」です");

        Hand computersHand = computer.getNextHand();
        this.console.println(computer.getSubject() + "が出したのは「" + HandName.toHandName(computersHand) + "」です");

        if (usersHand == computersHand) {
            this.console.println("あいこです。");
            return;
        }

        this.console.println((usersHand.winTo(computersHand) ? user.getSubject() : computer.getSubject()) + "の勝ちです。");
    }
}
