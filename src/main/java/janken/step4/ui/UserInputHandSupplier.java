package janken.step4.ui;

import janken.step4.logic.Hand;
import janken.step4.logic.HandNumber;
import janken.step4.logic.HandSupplier;

public class UserInputHandSupplier implements HandSupplier {

    private final Console console;

    public UserInputHandSupplier(Console console) {
        this.console = console;
    }

    @Override
    public Hand get() {
        UserInput userInput = this.console.readUserInput();

        if (!HandNumber.isValid(userInput.getValue())) {
            throw new IllegalInputException();
        }

        return HandNumber.toHand(userInput.toInt());
    }
}
