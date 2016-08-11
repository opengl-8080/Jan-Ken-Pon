package janken.step4;

import janken.JankenGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 第４ステップ、「すべてのエンティティを小さくすること」を適用.
 */
public class Step4 implements JankenGame {
    /**ユーザー*/
    private static final User USER = new User();
    /**コンピュータ*/
    private static final Computer COMPUTER = new Computer();

    /**
     * じゃんけんプログラムを開始する.
     */
    @Override
    public void execute() {
        try (BufferedReader standardInput = new BufferedReader(new InputStreamReader(System.in))) {
            this.executeMainProcessInfinitely(standardInput);
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }

    /**
     * メインのじゃんけん処理を、無限ループしながら実行する.
     * @param standardInput 標準入力をラップした {@link BufferedReader}.
     * @throws IOException 入力エラーが発生した場合.
     */
    private void executeMainProcessInfinitely(BufferedReader standardInput) throws IOException {
        while (true) {
            this.mainProcess(standardInput);
        }
    }

    /**
     * メインのじゃんけん処理.
     * @param standardInput 標準入力をラップした {@link BufferedReader}.
     * @throws IOException 入力エラーが発生した場合.
     */
    private void mainProcess(BufferedReader standardInput) throws IOException {
        System.out.println(
            "[" + Hand.ROCK.getNumber() + "]" + Hand.ROCK + "、" +
            "[" + Hand.SCISSORS.getNumber() + "]" + Hand.SCISSORS + "、" +
            "[" + Hand.PAPER.getNumber() + "]" + Hand.PAPER + "を入力して下さい ⇒ "
        );

        UserInput userInput = new UserInput(standardInput.readLine());

        if (!Hand.isValid(userInput.getValue())) {
            return;
        }

        Hand usersHand = Hand.of(userInput.toInt());
        System.out.println(USER.getSubject() + "が出したのは「" + usersHand + "」です");

        Hand computersHand = Hand.random();
        System.out.println(COMPUTER.getSubject() + "が出したのは「" + computersHand + "」です");

        if (usersHand == computersHand) {
            System.out.println("あいこです。");
            return;
        }

        System.out.println((usersHand.winTo(computersHand) ? USER.getSubject() : COMPUTER.getSubject()) + "の勝ちです。");
    }
}
