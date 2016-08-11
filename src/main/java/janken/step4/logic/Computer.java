package janken.step4.logic;

import java.util.Random;

/**
 * コンピュータ.
 */
public class Computer {
    /**次の手を決定するための {@link Random} インスタンス*/
    private final Random random;

    /**
     * {@link Random} を指定してインスタンスを生成する.
     * @param random ここで指定した {@link Random} インスタンスは、次の手を決定する際に使用されます.
     */
    public Computer(Random random) {
        this.random = random;
    }

    /**
     * 主語を取得する.
     * @return 主語
     */
    public String getSubject() {
        return "わたし";
    }

    /**
     * 次の出し手を取得する.
     * @return 次の出し手
     */
    public Hand getNextHand() {
        int number = this.random.nextInt(HandNumber.values().length);
        return HandNumber.toHand(number);
    }
}
