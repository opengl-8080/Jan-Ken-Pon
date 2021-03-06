package janken.step4.logic;

public enum HandName {
    ROCK("グー"),
    SCISSORS("チョキ"),
    PAPER("パー");

    private final String name;

    HandName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
