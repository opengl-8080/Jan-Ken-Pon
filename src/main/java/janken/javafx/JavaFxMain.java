package janken.javafx;

import janken.JankenGame;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * 最終的に出来上がったクラスを使って JavaFX でじゃんけんプログラムを実装した例.
 */
public class JavaFxMain extends Application implements JankenGame {

    @Override
    public void execute() {
        Application.launch(JavaFxMain.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent fxml = FXMLLoader.load(JavaFxMain.class.getResource("/fxml/main.fxml"));

        Scene scene = new Scene(fxml);
        primaryStage.setScene(scene);
        primaryStage.setTitle("じゃんけんゲーム");

        primaryStage.show();
    }
}
