package janken.step2;

import janken.JankenGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;

/**
 * 第２ステップ、「else 句を使用しないこと」を適用.
 * <p>
 * じゃんけんの結果判定に存在した else を除去するため、 {@link Hand} 列挙型を追加.<br>
 * else をポリモーフィズムで解決させた.
 * <p>
 * また、 {@code Map} などを使っていた部分や正規表現など、 {@link Hand} 列挙型が持っていたほうが自然なものは
 * そちらに移動させた.
 */
public class Step2 implements JankenGame {
    private static final String USER_NAME = "あなた";
    private static final String COMPUTER_NAME = "わたし";

    @Override
    public void execute() {
        try {
            BufferedReader standardInput = new BufferedReader(new InputStreamReader(System.in));
            this.executeMainProcessInfinitely(standardInput);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private void executeMainProcessInfinitely(BufferedReader standardInput) throws IOException {
        while (true) {
            this.mainProcess(standardInput);
        }
    }

    private void mainProcess(BufferedReader standardInput) throws IOException {
        System.out.println(
            "[" + Hand.ROCK.getNumber() + "]" + Hand.ROCK + "、" +
            "[" + Hand.SCISSORS.getNumber() + "]" + Hand.SCISSORS + "、" +
            "[" + Hand.PAPER.getNumber() + "]" + Hand.PAPER + "を入力して下さい ⇒ "
        );

        String userInput = standardInput.readLine();

        if (!Hand.isValid(userInput)) {
            return;
        }

        Hand usersHand = Hand.of(Integer.parseInt(userInput));
        System.out.println(USER_NAME + "が出したのは「" + usersHand + "」です");

        Hand computersHand = Hand.random();
        System.out.println(COMPUTER_NAME + "が出したのは「" + computersHand + "」です");

        if (usersHand == computersHand) {
            System.out.println("あいこです。");
            return;
        }

        System.out.println((usersHand.winTo(computersHand) ? USER_NAME : COMPUTER_NAME) + "の勝ちです。");
    }
}
