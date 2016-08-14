package janken.step5.logic;

import java.util.Random;

public enum Hand {
    ROCK(HandName.ROCK) {
        @Override
        public boolean winTo(Hand other) {
            return other == SCISSORS;
        }
    },
    SCISSORS(HandName.SCISSORS) {
        @Override
        public boolean winTo(Hand other) {
            return other == PAPER;
        }
    },
    PAPER(HandName.PAPER) {
        @Override
        public boolean winTo(Hand other) {
            return other == ROCK;
        }
    };

    private static final Random RANDOM = new Random(System.currentTimeMillis());

    public static Hand random() {
        return values()[RANDOM.nextInt(Hand.values().length)];
    }

    private final HandName name;

    Hand(HandName name) {
        this.name = name;
    }

    abstract public boolean winTo(Hand other);

    public HandName getName() {
        return this.name;
    }
}
