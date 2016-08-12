package janken.step4.ui;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;

public class ConsoleTest {

    @Test
    public void 指定した文字列の末尾に行区切り文字が追加された文字列が出力ストリームに書き出される() throws Exception {
        // setup
        ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(byteOutStream);
        Console console = new Console(System.in, out);

        // exercise
        console.println("Out Message");

        // verify
        String actual = new String(byteOutStream.toByteArray());
        assertThat(actual).isEqualTo("Out Message" + System.lineSeparator());
    }

    @Test
    public void 入力ストリームから取得した文字列をユーザー入力オブジェクトで返す() throws Exception {
        // setup
        InputStream in = new ByteArrayInputStream("In Message".getBytes());
        Console console = new Console(in, System.out);

        // exercise
        UserInput userInput = console.readUserInput();

        // verify
        assertThat(userInput.getValue()).isEqualTo("In Message");
    }
}