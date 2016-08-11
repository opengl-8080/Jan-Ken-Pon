package janken.step3;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 出し手の数値表現.
 */
public enum HandNumber {
    /**グー*/
    ROCK(Hand.ROCK, 1),
    /**チョキ*/
    SCISSORS(Hand.SCISSORS, 2),
    /**パー*/
    PAPER(Hand.PAPER, 3);

    /**ランダムな値を生成するための {@link Random} インスタンス*/
    private static final Random RANDOM = new Random(System.currentTimeMillis());

    /**出し手の数値表現にマッチする文字列かを判定するための正規表現*/
    private static final Pattern HAND_REGEXP_PATTERN =
            Pattern.compile("[" + ROCK.number + SCISSORS.number + PAPER.number + "]");

    /**
     * ランダムに出し手の数値表現を取得する.
     * @return ランダムに選択された出し手の数値表現.
     */
    public static HandNumber random() {
        return HandNumber.values()[RANDOM.nextInt(Hand.values().length)];
    }

    /**
     * 指定した文字列が出し手の数値表現にマッチするかどうか判定する.
     * @param textNumber 判定する文字列
     * @return 出し手の数値表現にマッチする場合は true
     */
    public static boolean isValid(String textNumber) {
        Matcher matcher = HAND_REGEXP_PATTERN.matcher(textNumber);
        return matcher.matches();
    }

    /**
     * 指定した数値に対応する出し手の数値表現列挙子を返却する.
     * @param number 数値
     * @return 対応する列挙子
     * @throws IllegalArgumentException 対応する列挙子が存在しない場合.
     */
    public static HandNumber of(int number) {
        if (number == ROCK.number) {
            return ROCK;
        }

        if (number == SCISSORS.number) {
            return SCISSORS;
        }

        if (number == PAPER.number) {
            return PAPER;
        }

        throw new IllegalArgumentException("不明な値です(" + number + ").");
    }

    /**実際の数値*/
    private final int number;
    /**対応する出し手*/
    private final Hand hand;

    /**
     * インスタンスを生成する.
     * @param hand 対応する出し手
     * @param number 実際の数値
     */
    HandNumber(Hand hand, int number) {
        this.hand = hand;
        this.number = number;
    }

    /**
     * この数値表現に対応する実際の出し手を取得する.
     * @return 対応する出し手
     */
    public Hand getHand() {
        return this.hand;
    }

    @Override
    public String toString() {
        return String.valueOf(this.number);
    }
}
