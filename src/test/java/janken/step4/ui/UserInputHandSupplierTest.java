package janken.step4.ui;

import janken.step4.logic.Hand;
import janken.step4.logic.HandNumber;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;

public class UserInputHandSupplierTest {

    @Test
    public void コンソールから読み取った入力に対応する出し手が取得できる() throws Exception {
        // setup
        InputStream in = new ByteArrayInputStream(HandNumber.SCISSORS.toString().getBytes());
        Console console = new Console(in, System.out);
        UserInputHandSupplier supplier = new UserInputHandSupplier(console);

        // exercise
        Hand hand = supplier.get();

        // verify
        assertThat(hand).isEqualTo(Hand.SCISSORS);
    }

    @Test
    public void ユーザー入力が不正な場合は例外がスローされる() throws Exception {
        // setup
        InputStream in = new ByteArrayInputStream("aaa".getBytes());
        Console console = new Console(in, System.out);
        UserInputHandSupplier supplier = new UserInputHandSupplier(console);

        // exercise
        assertThatThrownBy(supplier::get).isInstanceOf(IllegalInputException.class);
    }
}