package janken.step4;

import janken.JankenGame;
import janken.step4.controller.JankenController;
import janken.step4.logic.ComputerName;
import janken.step4.logic.UserName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;

/**
 * 第４ステップ、「すべてのエンティティを小さくすること」、
 * 「１つのクラスにつきインスタンス変数は２つまでにすること」を適用.
 * <p>
 * ※コメントは行数から除外しています.
 */
public class Step4 implements JankenGame {

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
