package janken.step5.logic;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public enum HandNumber {
    ROCK(1),
    SCISSORS(2),
    PAPER(3);

    private static final Random RANDOM = new Random(System.currentTimeMillis());

    private static final Pattern HAND_REGEXP_PATTERN =
            Pattern.compile("[" + ROCK.number + SCISSORS.number + PAPER.number + "]");

    public static Hand randomHand() {
        return HandNumber.values()[RANDOM.nextInt(Hand.values().length)].toHand();
    }

    public static boolean isValid(String textNumber) {
        Matcher matcher = HAND_REGEXP_PATTERN.matcher(textNumber);
        return matcher.matches();
    }

    public static Hand toHand(int number) {
        return Stream.of(values())
                     .filter(it -> it.number == number)
                     .map(it -> it.toHand())
                     .findFirst()
                     .orElseThrow(() -> new IllegalArgumentException("不明な値です(" + number + ")."));
    }

    private final int number;

    HandNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return String.valueOf(this.number);
    }

    Hand toHand() {
        return Hand.valueOf(this.name());
    }
}
