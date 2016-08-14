package janken;

import janken.javafx.JavaFxMain;
import janken.step6.Step6;
import janken.web.WebMain;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        JankenGame janken = new Step6();

        if (args.length != 0) {
            janken = decideJankenGame(args[0]);
        }

        System.out.println(janken.getClass().getSimpleName());
        janken.execute();
    }

    private static JankenGame decideJankenGame(String option) {
        if ("console".equalsIgnoreCase(option)) {
            return new Step6();
        }

        if ("web".equalsIgnoreCase(option)) {
            return new WebMain();
        }

        if ("gui".equalsIgnoreCase(option)) {
            return new JavaFxMain();
        }

        System.err.println("引数は console, web, gui のいずれかを指定してください。");
        System.exit(1);
        return null;
    }
}
