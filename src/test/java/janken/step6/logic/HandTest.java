package janken.step6.logic;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class HandTest {

    @Test
    public void グーはチョキに勝てる() throws Exception {
        assertThat(Hand.ROCK.winTo(Hand.SCISSORS)).isTrue();
    }

    @Test
    public void グーはチョキに負ける() throws Exception {
        assertThat(Hand.ROCK.winTo(Hand.PAPER)).isFalse();
    }

    @Test
    public void チョキはパーに勝てる() throws Exception {
        assertThat(Hand.SCISSORS.winTo(Hand.PAPER)).isTrue();
    }

    @Test
    public void チョキはグーに負ける() throws Exception {
        assertThat(Hand.SCISSORS.winTo(Hand.ROCK)).isFalse();
    }

    @Test
    public void パーはグーに勝てる() throws Exception {
        assertThat(Hand.PAPER.winTo(Hand.ROCK)).isTrue();
    }

    @Test
    public void パーはチョキに負ける() throws Exception {
        assertThat(Hand.PAPER.winTo(Hand.SCISSORS)).isFalse();
    }
}