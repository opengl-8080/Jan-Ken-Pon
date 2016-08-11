package janken.step4.logic;

/**
 * 出し手を表す列挙型.
 */
public enum Hand {
    /**グー*/
    ROCK {
        @Override
        public boolean winTo(Hand other) {
            return SCISSORS == other;
        }
    },
    /**チョキ*/
    SCISSORS {
        @Override
        public boolean winTo(Hand other) {
            return PAPER == other;
        }
    },
    /**パー*/
    PAPER {
        @Override
        public boolean winTo(Hand other) {
            return ROCK == other;
        }
    };

    /**
     * この出し手が、指定した出し手に勝てるかどうかを判定する.
     * @param other 比較対象の出し手
     * @return 勝てる場合は true
     */
    abstract public boolean winTo(Hand other);
}
