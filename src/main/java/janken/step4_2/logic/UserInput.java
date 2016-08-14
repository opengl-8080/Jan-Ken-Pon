package janken.step4_2.logic;

public class UserInput {
    private final String value;

    public UserInput(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public int toInt() {
        return Integer.parseInt(this.value);
    }
}
