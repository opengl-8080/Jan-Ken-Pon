package janken.step3;

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
