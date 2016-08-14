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
            this.printWinner(usersHand, computersHand);
        }
    }

    private void printWinner(int usersHand, int computersHand) {
        String winner;

        if (usersHand == ROCK) {
            winner = (computersHand == SCISSORS) ? USER_NAME : COMPUTER_NAME;
        } else if (usersHand == SCISSORS) {
            winner = (computersHand == PAPER) ? USER_NAME : COMPUTER_NAME;
        } else {
            winner = (computersHand == ROCK) ? USER_NAME : COMPUTER_NAME;
        }

        System.out.println(winner + "の勝ちです。");
    }
}
