package janken.step4.logic;

/**
 * 出し手の名称.
 */
public enum HandName {
    /**グー*/
    ROCK("グー"),
    /**チョキ*/
    SCISSORS("チョキ"),
    /**パー*/
    PAPER("パー");

    /**
     * 指定した出し手に対応する名称を取得する.
     * @param hand 出し手
     * @return 対応する名称
     */
    public static HandName toHandName(Hand hand) {
        return HandName.valueOf(hand.name());
    }

    /**実際の名称*/
    private final String name;

    /**
     * インスタンスを生成する.
     * @param name 実際の名称
     */
    HandName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
