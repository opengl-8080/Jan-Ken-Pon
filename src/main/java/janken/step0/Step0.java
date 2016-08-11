package janken.step0;

import janken.JankenGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 非オブジェクト指向、全力で見づらくした例.
 * <h3>問題点
 * <ul>
 *     <li>ロジックとユーザーインターフェースが密に結合しており、分離が困難.
 *     <li>単体テストの記述が困難.
 *     <li>どこに何についてのコードがあるのか分かりづらい.
 *     <li>コードの重複あり.
 * </ul>
 */
public class Step0 implements JankenGame {
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

            while (true) {
                System.out.println(
                    "[" + ROCK + "]" + DISPLAY_NAME_ROCK + "、" +
                    "[" + SCISSORS + "]" + DISPLAY_NAME_SCISSORS + "、" +
                    "[" + PAPER + "]" + DISPLAY_NAME_PAPER + "を入力して下さい ⇒ "
                );

                String userInput = standardInput.readLine();
                Matcher matcher = HAND_REGEXP_PATTERN.matcher(userInput);

                if (matcher.matches()) {
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
                        String winner;

                        if (usersHand == ROCK) {
                            if (computersHand == SCISSORS) {
                                winner = USER_SUBJECT;
                            } else {
                                winner = COMPUTER_SUBJECT;
                            }
                        } else if (usersHand == SCISSORS) {
                            if (computersHand == PAPER) {
                                winner = USER_SUBJECT;
                            } else {
                                winner = COMPUTER_SUBJECT;
                            }
                        } else {
                            if (computersHand == ROCK) {
                                winner = USER_SUBJECT;
                            } else {
                                winner = COMPUTER_SUBJECT;
                            }
                        }

                        System.out.println(winner + "の勝ちです。");
                    }
                }
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
