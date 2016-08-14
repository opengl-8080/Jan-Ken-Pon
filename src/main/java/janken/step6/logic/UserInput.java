package janken.step6.logic;

import java.util.function.Predicate;

public class UserInput {
    private final String value;

    public UserInput(String value) {
        this.value = value;
    }

    public int toInt() {
        return Integer.parseInt(this.value);
    }

    public boolean validate(Predicate<String> validator) {
        return validator.test(this.value);
    }
}
