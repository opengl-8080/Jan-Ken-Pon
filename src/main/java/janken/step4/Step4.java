package janken.step4;

import janken.JankenGame;
import janken.step4.controller.JankenController;
import janken.step4.logic.Computer;
import janken.step4.logic.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;

public class Step4 implements JankenGame {
    private final User user = new User();
    private final Computer computer = new Computer();
    private final BufferedReader standardInput = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void execute() {
        try {
            JankenController controller = new JankenController();
            controller.execute(this.user, this.computer, this.standardInput);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
