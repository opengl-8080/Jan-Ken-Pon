package janken.step2;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 出し手を表す列挙型.
 */
public enum Hand {
    /**グー*/
    ROCK("グー", 1) {
        @Override
        public boolean winTo(Hand other) {
            return other == SCISSORS;
        }
    },
    /**チョキ*/
    SCISSORS("チョキ", 2) {
        @Override
        public boolean winTo(Hand other) {
            return other == PAPER;
        }
    },
    /**パー*/
    PAPER("パー", 3) {
        @Override
        public boolean winTo(Hand other) {
            return other == ROCK;
        }
    };

    /**ランダムな値を生成するための {@link Random} インスタンス*/
    private static final Random RANDOM = new Random(System.currentTimeMillis());

    /**出し手の数値表現にマッチする文字列かを判定するための正規表現*/
    private static final Pattern HAND_REGEXP_PATTERN =
            Pattern.compile("[" + ROCK.number + SCISSORS.number + PAPER.number + "]");

    /**
     * ランダムに出し手を取得する.
     * @return ランダムに選択された出し手.
     */
    public static Hand random() {
        return Hand.of(RANDOM.nextInt(3) + 1);
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
     * 指定した出し手の数値表現に対応する出し手の列挙子を返却する.
     * @param handNumber 出し手の数値表現
     * @return 対応する列挙子
     * @throws IllegalArgumentException 対応する列挙子が存在しない場合.
     */
    public static Hand of(int handNumber) {
        if (handNumber == ROCK.number) {
            return ROCK;
        }

        if (handNumber == SCISSORS.number) {
            return SCISSORS;
        }

        if (handNumber == PAPER.number) {
            return PAPER;
        }

        throw new IllegalArgumentException("不明な値です(" + handNumber + ").");
    }

    /**出し手の表示用文字列*/
    private final String displayName;
    /**出し手の数値表現*/
    private final int number;

    Hand(String displayName, int handNumber) {
        this.displayName = displayName;
        this.number = handNumber;
    }

    /**
     * この出し手が、指定した出し手に勝てるかどうかを判定する.
     * @param other 比較対象の出し手
     * @return 勝てる場合は true
     */
    abstract public boolean winTo(Hand other);

    /**
     * この出し手の表示用の文字列を取得する.
     * @return 表示用の文字列
     */
    @Override
    public String toString() {
        return this.displayName;
    }

    /**
     * この出し手の数値での表現を取得する.
     * @return 数値での表現
     */
    public int getNumber() {
        return number;
    }
}
