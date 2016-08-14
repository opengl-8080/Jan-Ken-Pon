package janken.step2;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Hand {
    ROCK("グー", 1) {
        @Override
        public boolean winTo(Hand other) {
            return other == SCISSORS;
        }
    },
    SCISSORS("チョキ", 2) {
        @Override
        public boolean winTo(Hand other) {
            return other == PAPER;
        }
    },
    PAPER("パー", 3) {
        @Override
        public boolean winTo(Hand other) {
            return other == ROCK;
        }
    };

    private static final Random RANDOM = new Random(System.currentTimeMillis());

    private static final Pattern HAND_REGEXP_PATTERN =
            Pattern.compile("[" + ROCK.number + SCISSORS.number + PAPER.number + "]");

    public static Hand random() {
        return Hand.of(RANDOM.nextInt(Hand.values().length) + 1);
    }

    public static boolean isValid(String textNumber) {
        Matcher matcher = HAND_REGEXP_PATTERN.matcher(textNumber);
        return matcher.matches();
    }

    public static Hand of(int handNumber) {
        if (handNumber == ROCK.number) {
            return ROCK;
        }

        if (handNumber == SCISSORS.number) {
            return SCISSORS;
        }

        if (handNumber == PAPER.number) {
            return PAPER;
        }

        throw new IllegalArgumentException("不明な値です(" + handNumber + ").");
    }

    private final String displayName;
    private final int number;

    Hand(String displayName, int handNumber) {
        this.displayName = displayName;
        this.number = handNumber;
    }

    abstract public boolean winTo(Hand other);

    @Override
    public String toString() {
        return this.displayName;
    }

    public int getNumber() {
        return number;
    }
}
