package janken.step4;

import janken.JankenGame;
import janken.step4.logic.Computer;
import janken.step4.logic.HandName;
import janken.step4.logic.HandNumber;
import janken.step4.logic.Janken;
import janken.step4.logic.Player;
import janken.step4.logic.RandomHandSupplier;
import janken.step4.logic.User;
import janken.step4.ui.Console;
import janken.step4.ui.IllegalInputException;
import janken.step4.ui.UserInputHandSupplier;

import java.util.Random;

/**
 * 第４ステップ、「すべてのエンティティを小さくすること」を適用.
 */
public class Step4 implements JankenGame {
    /**ユーザー*/
    private User user;
    /**コンピュータ*/
    private Computer computer;
    /**コンソール*/
    private final Console console = new Console(System.in, System.out);
    /**じゃんけんを実行するクラス*/
    private Janken janken;

    /**
     * じゃんけんプログラムを開始する.
     */
    @Override
    public void execute() {
        this.user = new User(new UserInputHandSupplier(this.console));
        this.computer = new Computer(new RandomHandSupplier(new Random(System.currentTimeMillis())));
        this.janken = new Janken(this.user, this.computer);

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

        try {
            this.janken.pon();
            this.console.println(this.user.getSubject() + "が出したのは「" + HandName.toHandName(this.user.getHand()) + "」です");
            this.console.println(this.computer.getSubject() + "が出したのは「" + HandName.toHandName(this.computer.getHand()) + "」です");

            if (this.janken.isDraw()) {
                this.console.println("あいこです。");
                return;
            }

            Player winner = this.janken.getWinner();
            this.console.println(winner.getSubject() + "の勝ちです。");
        } catch (IllegalInputException e) {
            // 入力不正はスキップ
        }
    }
}
