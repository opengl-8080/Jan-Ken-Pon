package janken.step6;

import janken.JankenGame;
import janken.step6.controller.JankenController;
import janken.step6.logic.ComputerName;
import janken.step6.logic.UserName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;

/**
 * 第６ステップ、「Getter, Setter, プロパティを使用しないこと」を適用（終了）.
 */
public class Step6 implements JankenGame {
    @Override
    public void execute() {
        try {
            UserName user = new UserName();
            ComputerName computer = new ComputerName();
            BufferedReader standardInput = new BufferedReader(new InputStreamReader(System.in));

            JankenController controller = new JankenController();
            controller.execute(user, computer, standardInput);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
