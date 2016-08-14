package janken.step6.logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * 出し手の数値表現を表す列挙型.
 */
public enum HandNumber {
    /**グー*/
    ROCK(1),
    /**チョキ*/
    SCISSORS(2),
    /**パー*/
    PAPER(3);

    /**妥当な数値表現にマッチする正規表現*/
    private static final Pattern HAND_REGEXP_PATTERN =
            Pattern.compile("[" + ROCK.number + SCISSORS.number + PAPER.number + "]");

    /**
     * 指定した文字列が出し手の数値表現として妥当かどうかを検証する.
     * @param textNumber 検証対象の文字列
     * @return 妥当である場合は true
     */
    public static boolean isValid(String textNumber) {
        Matcher matcher = HAND_REGEXP_PATTERN.matcher(textNumber);
        return matcher.matches();
    }

    /**
     * 指定した数値表現に対応する出し手を取得する.
     * @param number 数値表現
     * @return 対応する出し手
     */
    public static Hand toHand(int number) {
        return Stream.of(values())
                     .filter(it -> it.number == number)
                     .map(it -> it.toHand())
                     .findFirst()
                     .orElseThrow(() -> new IllegalArgumentException("不明な値です(" + number + ")."));
    }

    /**この数値表現の実際の値*/
    private final int number;

    /**
     * コンストラクタ.
     * @param number 実際の値
     */
    HandNumber(int number) {
        this.number = number;
    }

    /**
     * この数値表現の実際の値を文字列で返す.
     * @return 数値表現の文字列形式
     */
    @Override
    public String toString() {
        return String.valueOf(this.number);
    }

    /**
     * この数値表現に対応する出し手を取得する.
     * @return 対応する出し手
     */
    Hand toHand() {
        return Hand.valueOf(this.name());
    }
}
