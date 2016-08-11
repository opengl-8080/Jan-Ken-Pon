package janken.step3;

/**
 * 出し手を表す列挙型.
 */
public enum Hand {
    /**グー*/
    ROCK(HandName.ROCK) {
        @Override
        public boolean winTo(Hand other) {
            return other == SCISSORS;
        }
    },
    /**チョキ*/
    SCISSORS(HandName.SCISSORS) {
        @Override
        public boolean winTo(Hand other) {
            return other == PAPER;
        }
    },
    /**パー*/
    PAPER(HandName.PAPER) {
        @Override
        public boolean winTo(Hand other) {
            return other == ROCK;
        }
    };

    /**出し手の名称*/
    private final HandName name;

    /**
     * インスタンスを生成する.
     * @param name 出し手の名称
     */
    Hand(HandName name) {
        this.name = name;
    }

    /**
     * この出し手が、指定した出し手に勝てるかどうかを判定する.
     * @param other 比較対象の出し手
     * @return 勝てる場合は true
     */
    abstract public boolean winTo(Hand other);

    /**
     * この出し手の名称を取得する.
     * @return 名称
     */
    public HandName getName() {
        return this.name;
    }
}
