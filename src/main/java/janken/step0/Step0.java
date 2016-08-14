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
    private static final Random RANDOM = new Random(System.currentTimeMillis());
    private static final int ROCK = 1;
    private static final int SCISSORS = 2;
    private static final int PAPER = 3;
    private static final String USER_NAME = "あなた";
    private static final String COMPUTER_NAME = "わたし";
    private static final String DISPLAY_NAME_ROCK = "グー";
    private static final String DISPLAY_NAME_SCISSORS = "チョキ";
    private static final String DISPLAY_NAME_PAPER = "パー";
    private static final Pattern HAND_REGEXP_PATTERN = Pattern.compile("[" + ROCK + SCISSORS + PAPER + "]");

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

                    System.out.println(USER_NAME + "が出したのは「" + handDisplayName + "」です");

                    int computersHand = RANDOM.nextInt(3) + 1;

                    if (computersHand == ROCK) {
                        handDisplayName = DISPLAY_NAME_ROCK;
                    } else if (computersHand == SCISSORS) {
                        handDisplayName = DISPLAY_NAME_SCISSORS;
                    } else {
                        handDisplayName = DISPLAY_NAME_PAPER;
                    }

                    System.out.println(COMPUTER_NAME + "が出したのは「" + handDisplayName + "」です");

                    if (usersHand == computersHand) {
                        System.out.println("あいこです。");
                    } else {
                        String winner;

                        if (usersHand == ROCK) {
                            if (computersHand == SCISSORS) {
                                winner = USER_NAME;
                            } else {
                                winner = COMPUTER_NAME;
                            }
                        } else if (usersHand == SCISSORS) {
                            if (computersHand == PAPER) {
                                winner = USER_NAME;
                            } else {
                                winner = COMPUTER_NAME;
                            }
                        } else {
                            if (computersHand == ROCK) {
                                winner = USER_NAME;
                            } else {
                                winner = COMPUTER_NAME;
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
