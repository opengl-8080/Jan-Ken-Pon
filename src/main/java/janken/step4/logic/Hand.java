package janken.step4.logic;

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

    private final HandName name;

    Hand(HandName name) {
        this.name = name;
    }

    abstract public boolean winTo(Hand other);

    public HandName getName() {
        return this.name;
    }
}
