package janken.step3;

import janken.JankenGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 第３ステップ、「すべてのプリミティブ型と文字列型をラップすること」を適用.
 * <p>
 * 以下の値を、クラスにラップした.
 * <ul>
 *   <li>ユーザーの主語→{@link User}
 *   <li>コンピュータの主語→{@link Computer}
 *   <li>出し手の数値表現→{@link HandNumber}
 *   <li>出し手の名称→{@link HandName}
 * </ul>
 */
public class Step3 implements JankenGame {
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
            "[" + HandNumber.ROCK + "]" + HandName.ROCK + "、" +
            "[" + HandNumber.SCISSORS + "]" + HandName.SCISSORS + "、" +
            "[" + HandNumber.PAPER + "]" + HandName.PAPER + "を入力して下さい ⇒ "
        );

        UserInput userInput = new UserInput(standardInput.readLine());

        if (!HandNumber.isValid(userInput.getValue())) {
            return;
        }

        Hand usersHand = HandNumber.of(userInput.toInt()).getHand();
        System.out.println(USER.getSubject() + "が出したのは「" + usersHand.getName() + "」です");

        Hand computersHand = HandNumber.random().getHand();
        System.out.println(COMPUTER.getSubject() + "が出したのは「" + computersHand.getName() + "」です");

        if (usersHand == computersHand) {
            System.out.println("あいこです。");
            return;
        }

        System.out.println((usersHand.winTo(computersHand) ? USER.getSubject() : COMPUTER.getSubject()) + "の勝ちです。");
    }
}
