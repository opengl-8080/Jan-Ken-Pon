package janken.step4.logic;

import org.junit.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.*;

public class RandomHandSupplierTest {

    @Test
    public void 指定したRandomが返した値に対応する出し手が取得できる() throws Exception {
        // setup
        RandomHandSupplier supplier = new RandomHandSupplier(new TestRandom(HandNumber.PAPER));

        // exercise
        Hand hand = supplier.get();

        // verify
        assertThat(hand).isEqualTo(Hand.PAPER);
    }

    /**
     * テスト用に次の値を確定させる {@link Random} の実装.
     */
    private static class TestRandom extends Random {

        private final HandNumber number;

        /**
         * 次の値を指定してインスタンスを生成する.
         * @param number 次に出す出し手の数値表現
         */
        private TestRandom(HandNumber number) {
            this.number = number;
        }

        @Override
        public int nextInt(int n) {
            return Integer.parseInt(this.number.toString()) - 1;
        }
    }
}