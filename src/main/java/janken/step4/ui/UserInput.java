package janken.step4.ui;

/**
 * ユーザーが入力した値.
 */
public class UserInput {
    /**入力値*/
    private final String value;

    /**
     * インスタンスを生成する.
     * @param value 入力値
     */
    public UserInput(String value) {
        this.value = value;
    }

    /**
     * 入力値を取得する.
     * @return 入力値
     */
    public String getValue() {
        return value;
    }

    /**
     * 入力値を {@code int} 型で取得する.
     * @return 入力値を {@code int} に変換した値.
     */
    public int toInt() {
        return Integer.parseInt(this.value);
    }
}
