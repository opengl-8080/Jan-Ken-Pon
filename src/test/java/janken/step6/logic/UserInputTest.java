package janken.step6.logic;

import org.junit.Test;

import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.*;

public class UserInputTest {

    private boolean validatorIsCalled;

    @Test
    public void 検証処理にはユーザー入力が持つ値が渡される() throws Exception {
        // setup
        UserInput userInput = new UserInput("Value");

        Predicate<String> validator = (value) -> {
            // verify
            assertThat(value).isEqualTo("Value");
            validatorIsCalled = true;
            return false;
        };

        // exercise
        userInput.validate(validator);

        // verify
        assertThat(validatorIsCalled).isTrue();
    }

    @Test
    public void 指定した検証処理が返した真偽値を返す() throws Exception {
        // setup
        UserInput userInput = new UserInput("Value");
        Predicate<String> validator = (value) -> true;

        // exercise
        boolean result = userInput.validate(validator);

        // verify
        assertThat(result).isTrue();
    }

    @Test
    public void 入力値を数値で取得できる() throws Exception {
        // setup
        UserInput userInput = new UserInput("123");

        // verify
        assertThat(userInput.toInt()).isEqualTo(123);
    }
}