package janken.step4.logic;

import janken.step4.test.TestPlayer;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {

    @Test
    public void インスタンスを生成した直後はどの出し手でもない() throws Exception {
        // setup
        Player player = new TestPlayer(Hand.ROCK);

        // exercise
        assertThat(player.is(Hand.ROCK)).as("グー").isFalse();
        assertThat(player.is(Hand.SCISSORS)).as("チョキ").isFalse();
        assertThat(player.is(Hand.PAPER)).as("パー").isFalse();
    }

    @Test
    public void じゃんけんを実行したら_出し手のSupplierが返した出し手を返す() throws Exception {
        // setup
        Player player = new TestPlayer(Hand.ROCK);

        // exercise
        Hand hand = player.pon();

        // verify
        assertThat(hand).isEqualTo(Hand.ROCK);
    }

    @Test
    public void じゃんけんで出した手を保持する() throws Exception {
        // setup
        Player player = new TestPlayer(Hand.ROCK);

        // exercise
        player.pon();

        // verify
        assertThat(player.is(Hand.SCISSORS)).isTrue();
    }
}