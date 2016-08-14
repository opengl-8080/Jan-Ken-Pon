package janken.step6;

import janken.JankenGame;
import janken.step6.controller.JankenController;
import janken.step6.logic.ComputerSubject;
import janken.step6.logic.UserSubject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;

/**
 * 第６ステップ、「Getter, Setter, プロパティを使用しないこと」を適用.
 */
public class Step6 implements JankenGame {
    @Override
    public void execute() {
        try {
            UserSubject user = new UserSubject();
            ComputerSubject computer = new ComputerSubject();
            BufferedReader standardInput = new BufferedReader(new InputStreamReader(System.in));

            JankenController controller = new JankenController();
            controller.execute(user, computer, standardInput);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
