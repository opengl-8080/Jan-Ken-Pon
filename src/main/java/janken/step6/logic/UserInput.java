package janken.step6.logic;

import java.util.function.Predicate;

/**
 * ユーザー入力.
 */
public class UserInput {
    /**実際の値*/
    private final String value;

    /**
     * ユーザーが実際に入力した値を指定してインスタンスを生成する.
     * @param value ユーザーが実際に入力した値.
     */
    public UserInput(String value) {
        this.value = value;
    }

    /**
     * このユーザー入力値を {@cod int} 型に変換して取得する.
     * @return ユーザー入力の {@code int} 変換値
     */
    public int toInt() {
        return Integer.parseInt(this.value);
    }

    /**
     * このユーザー入力が、指定した検証処理の条件を満たすかどうか判定する.
     * @param validator 検証処理. パラメータとしてこの入力の実際の値が渡される.
     * @return 条件を満たす場合は true
     */
    public boolean validate(Predicate<String> validator) {
        return validator.test(this.value);
    }
}
