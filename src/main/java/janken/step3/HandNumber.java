package janken.step3;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum HandNumber {
    ROCK(Hand.ROCK, 1),
    SCISSORS(Hand.SCISSORS, 2),
    PAPER(Hand.PAPER, 3);

    private static final Random RANDOM = new Random(System.currentTimeMillis());

    private static final Pattern HAND_REGEXP_PATTERN =
            Pattern.compile("[" + ROCK.number + SCISSORS.number + PAPER.number + "]");

    public static HandNumber random() {
        return HandNumber.values()[RANDOM.nextInt(Hand.values().length)];
    }

    public static boolean isValid(String textNumber) {
        Matcher matcher = HAND_REGEXP_PATTERN.matcher(textNumber);
        return matcher.matches();
    }

    public static HandNumber of(int number) {
        if (number == ROCK.number) {
            return ROCK;
        }

        if (number == SCISSORS.number) {
            return SCISSORS;
        }

        if (number == PAPER.number) {
            return PAPER;
        }

        throw new IllegalArgumentException("不明な値です(" + number + ").");
    }

    private final int number;
    private final Hand hand;

    HandNumber(Hand hand, int number) {
        this.hand = hand;
        this.number = number;
    }

    public Hand getHand() {
        return this.hand;
    }

    @Override
    public String toString() {
        return String.valueOf(this.number);
    }
}
