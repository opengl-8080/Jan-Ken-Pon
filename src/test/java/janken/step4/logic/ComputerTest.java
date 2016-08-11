package janken.step4.logic;

import janken.step4.logic.Computer;
import janken.step4.logic.Hand;
import janken.step4.logic.HandNumber;
import org.junit.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.*;

public class ComputerTest {

    @Test
    public void Randomオブジェクトが生成した数値をもとに決定された次の出し手を取得できる_グー() throws Exception {
        // setup
        Computer computer = new Computer(new TestRandom(HandNumber.ROCK));

        // exercise
        Hand hand = computer.getNextHand();

        // verify
        assertThat(hand).isEqualTo(Hand.ROCK);
    }

    @Test
    public void Randomオブジェクトが生成した数値をもとに決定された次の出し手を取得できる_チョキ() throws Exception {
        // setup
        Computer computer = new Computer(new TestRandom(HandNumber.SCISSORS));

        // exercise
        Hand hand = computer.getNextHand();

        // verify
        assertThat(hand).isEqualTo(Hand.SCISSORS);
    }

    @Test
    public void Randomオブジェクトが生成した数値をもとに決定された次の出し手を取得できる_パー() throws Exception {
        // setup
        Computer computer = new Computer(new TestRandom(HandNumber.PAPER));

        // exercise
        Hand hand = computer.getNextHand();

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
            return Integer.parseInt(this.number.toString());
        }
    }
}