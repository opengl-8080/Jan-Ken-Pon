package janken.step6.logic;

/**
 * 出し手の名称を表す列挙型.
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
    public static HandName of(Hand hand) {
        return HandName.valueOf(hand.name());
    }

    /**この出し手の名称*/
    private final String name;

    /**
     * コンストラクタ.
     * @param name 名称
     */
    HandName(String name) {
        this.name = name;
    }

    /**
     * この出し手の名称そのものを返す.
     * @return 出し手の名称
     */
    @Override
    public String toString() {
        return this.name;
    }
}
