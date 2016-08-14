package janken.step6.logic;

public enum HandName {
    ROCK("グー"),
    SCISSORS("チョキ"),
    PAPER("パー");

    public static HandName of(Hand hand) {
        return HandName.valueOf(hand.name());
    }

    private final String name;

    HandName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
