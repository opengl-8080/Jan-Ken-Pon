package janken.step4.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UncheckedIOException;

/**
 * コンソールの入出力を担当するクラス.
 */
public class Console {
    /**入力*/
    private final BufferedReader reader;
    /**出力*/
    private final PrintStream out;

    /**
     * 入出力のストリームを指定してインスタンスを生成する.
     * @param in 入力ストリーム
     * @param out 出力ストリーム
     */
    public Console(InputStream in, PrintStream out) {
        this.reader = new BufferedReader(new InputStreamReader(in));
        this.out = out;
    }

    /**
     * 指定した文字列を出力ストリームに書き出す.
     * @param message 出力する文字列
     */
    public void println(String message) {
        this.out.println(message);
    }

    /**
     * 入力ストリームから１行取得し、ユーザー入力として返す.
     * @return ユーザー入力
     */
    public UserInput readUserInput() {
        try {
            return new UserInput(this.reader.readLine());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
