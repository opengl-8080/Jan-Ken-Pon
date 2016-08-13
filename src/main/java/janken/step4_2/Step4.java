package janken.step4_2;

import janken.JankenGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;

public class Step4 implements JankenGame {
    private final User user = new User();
    private final Computer computer = new Computer();

    @Override
    public void execute() {
        try {
            BufferedReader standardInput = new BufferedReader(new InputStreamReader(System.in));
            this.executeMainProcessInfinitely(standardInput);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private void executeMainProcessInfinitely(BufferedReader standardInput) throws IOException {
        while (true) {
            this.mainProcess(standardInput);
        }
    }

    private void mainProcess(BufferedReader standardInput) throws IOException {
        System.out.println(
            "[" + HandNumber.ROCK + "]" + HandName.ROCK + "、" +
            "[" + HandNumber.SCISSORS + "]" + HandName.SCISSORS + "、" +
            "[" + HandNumber.PAPER + "]" + HandName.PAPER + "を入力して下さい ⇒ "
        );

        UserInput userInput = new UserInput(standardInput.readLine());

        if (!HandNumber.isValid(userInput.getValue())) {
            return;
        }

        Hand usersHand = HandNumber.of(userInput.toInt()).toHand();
        System.out.println(user.getSubject() + "が出したのは「" + usersHand.getName() + "」です");

        Hand computersHand = HandNumber.random().toHand();
        System.out.println(computer.getSubject() + "が出したのは「" + computersHand.getName() + "」です");

        if (usersHand == computersHand) {
            System.out.println("あいこです。");
            return;
        }

        System.out.println((usersHand.winTo(computersHand) ? user.getSubject() : computer.getSubject()) + "の勝ちです。");
    }
}
