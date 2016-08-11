package janken.step4.logic;

import java.util.stream.Stream;

/**
 * 出し手の数値表現.
 */
public enum HandNumber {
    /**グー*/
    ROCK(1),
    /**チョキ*/
    SCISSORS(2),
    /**パー*/
    PAPER(3);

    /**
     * 指定した文字列が出し手の数値表現にマッチするかどうか判定する.
     * @param textNumber 判定する文字列
     * @return 出し手の数値表現にマッチする場合は true
     */
    public static boolean isValid(String textNumber) {
        return textNumber.matches("[" + ROCK.number + SCISSORS.number + PAPER.number + "]");
    }

    /**
     * 指定した数値に対応する出し手({@link Hand})を返却する.
     * @param number 数値
     * @return 対応する出し手
     * @throws IllegalArgumentException 対応する出し手が存在しない場合.
     */
    public static Hand toHand(int number) {
        return Stream.of(values())
              .filter(it -> it.number == number)
              .map(it -> Hand.valueOf(it.name()))
              .findFirst()
              .orElseThrow(() -> new IllegalArgumentException("不明な値です(" + number + ")."));
    }

    /**実際の数値*/
    private final int number;

    /**
     * インスタンスを生成する.
     * @param number 実際の数値
     */
    HandNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return String.valueOf(this.number);
    }
}
