package janken.step1;

import janken.JankenGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 第１ステップ、「１つのメソッドにつきインデントは１段階までにすること」を適用.
 */
public class Step1 implements JankenGame {
    /**ランダムな値を生成するための {@link Random} インスタンス*/
    private static final Random RANDOM = new Random(System.currentTimeMillis());
    /**グー*/
    private static final int ROCK = 1;
    /**チョキ*/
    private static final int SCISSORS = 2;
    /**パー*/
    private static final int PAPER = 3;
    /**ユーザーの主語*/
    private static final String USER_SUBJECT = "あなた";
    /**コンピュータの主語*/
    private static final String COMPUTER_SUBJECT = "わたし";
    /**グーの表示名*/
    private static final String DISPLAY_NAME_ROCK = "グー";
    /**チョキの表示名*/
    private static final String DISPLAY_NAME_SCISSORS = "チョキ";
    /**パーの表示名*/
    private static final String DISPLAY_NAME_PAPER = "パー";
    /**出し手が規定の値かどうかを判定するための正規表現パターン*/
    private static final Pattern HAND_REGEXP_PATTERN = Pattern.compile("[" + ROCK + SCISSORS + PAPER + "]");

    /**
     * じゃんけんプログラムを開始する.
     */
    @Override
    public void execute() {
        try {
            BufferedReader standardInput = new BufferedReader(new InputStreamReader(System.in));
            this.executeMainProcessInfinitely(standardInput);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
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
            "[" + ROCK + "]" + DISPLAY_NAME_ROCK + "、" +
            "[" + SCISSORS + "]" + DISPLAY_NAME_SCISSORS + "、" +
            "[" + PAPER + "]" + DISPLAY_NAME_PAPER + "を入力して下さい ⇒ "
        );

        String userInput = standardInput.readLine();
        Matcher matcher = HAND_REGEXP_PATTERN.matcher(userInput);

        if (!matcher.matches()) {
            return;
        }

        int usersHand = Integer.parseInt(userInput);

        String handDisplayName;

        if (usersHand == ROCK) {
            handDisplayName = DISPLAY_NAME_ROCK;
        } else if (usersHand == SCISSORS) {
            handDisplayName = DISPLAY_NAME_SCISSORS;
        } else {
            handDisplayName = DISPLAY_NAME_PAPER;
        }

        System.out.println(USER_SUBJECT + "が出したのは「" + handDisplayName + "」です");

        int computersHand = RANDOM.nextInt(3) + 1;

        if (computersHand == ROCK) {
            handDisplayName = DISPLAY_NAME_ROCK;
        } else if (computersHand == SCISSORS) {
            handDisplayName = DISPLAY_NAME_SCISSORS;
        } else {
            handDisplayName = DISPLAY_NAME_PAPER;
        }

        System.out.println(COMPUTER_SUBJECT + "が出したのは「" + handDisplayName + "」です");

        if (usersHand == computersHand) {
            System.out.println("あいこです。");
        } else {
            this.printWinner(usersHand, computersHand);
        }
    }

    /**
     * ユーザーとコンピュータの出し手を比較して、勝者の情報を出力する.
     * <p>
     * このメソッドはあいこ以外で使用されることを前提としています.
     * @param usersHand ユーザーの出し手
     * @param computersHand コンピュータの出し手
     */
    private void printWinner(int usersHand, int computersHand) {
        String winner;

        if (usersHand == ROCK) {
            winner = (computersHand == SCISSORS) ? USER_SUBJECT : COMPUTER_SUBJECT;
        } else if (usersHand == SCISSORS) {
            winner = (computersHand == PAPER) ? USER_SUBJECT : COMPUTER_SUBJECT;
        } else {
            winner = (computersHand == ROCK) ? USER_SUBJECT : COMPUTER_SUBJECT;
        }

        System.out.println(winner + "の勝ちです。");
    }
}
