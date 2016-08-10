package janken.step3;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class UserInputTest {

    @Test
    public void 入力値を数値で取得できる() throws Exception {
        // setup
        UserInput userInput = new UserInput("123");

        // verify
        assertThat(userInput.toInt()).isEqualTo(123);
    }
}