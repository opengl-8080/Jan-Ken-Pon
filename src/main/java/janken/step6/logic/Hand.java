package janken.step6.logic;

import java.util.Random;

/**
 * 出し手を表す列挙型.
 */
public enum Hand {
    /**グー*/
    ROCK {
        @Override
        public boolean winTo(Hand other) {
            return other == SCISSORS;
        }
    },
    /**チョキ*/
    SCISSORS {
        @Override
        public boolean winTo(Hand other) {
            return other == PAPER;
        }
    },
    /**パー*/
    PAPER {
        @Override
        public boolean winTo(Hand other) {
            return other == ROCK;
        }
    };

    /**ランダムな出し手を決定するための乱数生成インスタンス*/
    private static final Random RANDOM = new Random(System.currentTimeMillis());

    /**
     * ランダムな出し手を取得する.
     * @return ランダムな出し手
     */
    public static Hand random() {
        return values()[RANDOM.nextInt(Hand.values().length)];
    }

    /**
     * この出し手が、指定した出し手と勝負した場合に勝利するかどうかを判定する.
     * @param other 勝負対象の出し手
     * @return この出し手が勝つ場合は true
     */
    abstract public boolean winTo(Hand other);
}
