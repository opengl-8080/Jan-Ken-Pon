package janken.step4.logic;

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

    public static HandNumber random() {
        return HandNumber.values()[RANDOM.nextInt(Hand.values().length)];
    }

    public static boolean isValid(String textNumber) {
        Matcher matcher = HAND_REGEXP_PATTERN.matcher(textNumber);
        return matcher.matches();
    }

    public static HandNumber of(int number) {
        return Stream.of(values())
                     .filter(it -> it.number == number)
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

    public Hand toHand() {
        return Hand.valueOf(this.name());
    }
}
