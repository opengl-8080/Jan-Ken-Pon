package janken.step1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 第一ステップ、「１つのメソッドにつきインデントは１段階までにすること」を適用.
 */
public class Step1 {
    /**ランダムな値を生成するための {@link Random} インスタンス*/
    private static final Random RANDOM = new Random(System.currentTimeMillis());
    /**入力が不正であったことを表す値*/
    private static final int INVALID_HAND = -1;
    /**グー*/
    private static final int ROCK = 1;
    /**チョキ*/
    private static final int SCISSORS = 2;
    /**パー*/
    private static final int PAPER = 3;
    /**出し手ごとの表示名を保持したマップ*/
    private static final Map<Integer, String> HAND_DISPLAY_NAME_MAP;
    /**ユーザーの主語*/
    private static final String USER_SUBJECT = "あなた";
    /**コンピュータの主語*/
    private static final String COMPUTER_SUBJECT = "わたし";
    /**出し手が規定の値かどうかを判定するための正規表現パターン*/
    private static final Pattern HAND_REGEXP_PATTERN = Pattern.compile("[" + ROCK + SCISSORS + PAPER + "]");

    static {
        Map<Integer, String> map = new HashMap<>();

        map.put(ROCK, "グー");
        map.put(SCISSORS, "チョキ");
        map.put(PAPER, "パー");

        HAND_DISPLAY_NAME_MAP = Collections.unmodifiableMap(map);
    }

    /**
     * じゃんけんプログラムを開始する.
     */
    public void execute() {
        try (BufferedReader standardInput = new BufferedReader(new InputStreamReader(System.in))) {
            this.processMainInfinitely(standardInput);
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }

    /**
     * メインの処理を無限ループしながら実行する.
     * @param standardInput 標準入力をラップした {@link BufferedReader}
     * @throws IOException 入力エラーが発生した場合.
     */
    private void processMainInfinitely(BufferedReader standardInput) throws IOException {
        while (true) {
            mainProcess(standardInput);
        }
    }

    /**
     * じゃんけんプログラムのメインの処理
     * @param standardInput 標準入力をラップした {@link BufferedReader}
     * @throws IOException 入力エラーが発生した場合.
     */
    private void mainProcess(BufferedReader standardInput) throws IOException {
        int usersHand = this.readUsersHand(standardInput);

        if (usersHand != INVALID_HAND) {
            this.printHandDescription(USER_SUBJECT, usersHand);

            int computersHand = this.readComputersHand();
            this.printHandDescription(COMPUTER_SUBJECT, computersHand);

            this.printResult(usersHand, computersHand);
        }
    }

    /**
     * 標準入力からユーザーの出し手の入力を取得し、 {@code int} 型に変換して返す.
     * @param standardInput 標準入力をラップした {@link BufferedReader}
     * @return ユーザーの入力した出し手.<br>
     *         入力値が不正であった場合は、{@link #INVALID_HAND} の値が返される.
     * @throws IOException 入力エラーが発生した場合.
     */
    private int readUsersHand(BufferedReader standardInput) throws IOException {
        System.out.println(
            "[" + ROCK + "]" + HAND_DISPLAY_NAME_MAP.get(ROCK) + "、" +
            "[" + SCISSORS + "]" + HAND_DISPLAY_NAME_MAP.get(SCISSORS) + "、" +
            "[" + PAPER + "]" + HAND_DISPLAY_NAME_MAP.get(PAPER) + "を入力して下さい ⇒ "
        );

        String userInput = standardInput.readLine();

        return this.isValidInput(userInput) ? Integer.parseInt(userInput) : INVALID_HAND;
    }

    /**
     * ユーザーの入力値が有効かどうかを判定する.
     * @param userInput ユーザーの入力値
     * @return 有効な場合は true
     */
    private boolean isValidInput(String userInput) {
        Matcher matcher = HAND_REGEXP_PATTERN.matcher(userInput);
        return matcher.matches();
    }

    /**
     * コンピュータの出し手を取得する.
     * @return コンピュータの出し手.
     */
    private int readComputersHand() {
        return RANDOM.nextInt(3) + 1;
    }

    /**
     * 出し手について説明するメッセージを出力する.
     * @param subject 主語
     * @param hand 出し手
     */
    private void printHandDescription(String subject, int hand) {
        System.out.println(subject + "が出したのは「" + HAND_DISPLAY_NAME_MAP.get(hand) + "」です");
    }

    /**
     * ユーザーとコンピュータの出し手を比較して、勝負の結果を出力する.
     * @param usersHand ユーザーの出し手
     * @param computersHand コンピュータの出し手
     */
    private void printResult(int usersHand, int computersHand) {
        if (usersHand == computersHand) {
            System.out.println("あいこです。");
        } else {
            this.printWinner(usersHand, computersHand);
        }
    }

    /**
     * ユーザーとコンピュータの出し手を比較して、勝者を示すメッセージを出力する.
     * <p>
     * このメソッドは、あいこ以外のケースで実行されることを前提としています.
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
