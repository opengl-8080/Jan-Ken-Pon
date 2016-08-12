package janken.step4.logic;

import janken.step4.test.TestPlayer;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class JankenTest {

    @Test
    public void 登録された２人のプレイヤーでじゃんけんを実行し_勝者を取得できる() throws Exception {
        // setup
        Player p1 = new TestPlayer(Hand.ROCK);
        Player p2 = new TestPlayer(Hand.SCISSORS);

        Janken janken = new Janken(p1, p2);

        // exercise
        janken.pon();

        // verify
        assertThat(janken.getWinner()).isSameAs(p1);
    }

    @Test
    public void あいこかどうか確認できる_あいこの場合() throws Exception {
        // setup
        Player p1 = new TestPlayer(Hand.SCISSORS);
        Player p2 = new TestPlayer(Hand.SCISSORS);

        Janken janken = new Janken(p1, p2);

        // exercise
        janken.pon();

        // verify
        assertThat(janken.isDraw()).isTrue();
    }

    @Test
    public void あいこかどうか確認できる_あいこでない場合() throws Exception {
        // setup
        Player p1 = new TestPlayer(Hand.SCISSORS);
        Player p2 = new TestPlayer(Hand.PAPER);

        Janken janken = new Janken(p1, p2);

        // exercise
        janken.pon();

        // verify
        assertThat(janken.isDraw()).isFalse();
    }
}