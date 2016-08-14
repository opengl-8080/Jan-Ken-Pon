package janken.step6.logic;

public enum Hand {
    ROCK {
        @Override
        public boolean winTo(Hand other) {
            return other == SCISSORS;
        }
    },
    SCISSORS {
        @Override
        public boolean winTo(Hand other) {
            return other == PAPER;
        }
    },
    PAPER {
        @Override
        public boolean winTo(Hand other) {
            return other == ROCK;
        }
    };

    abstract public boolean winTo(Hand other);
}
