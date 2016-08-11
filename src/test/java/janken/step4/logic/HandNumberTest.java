package janken.step4.logic;

import janken.step4.logic.Hand;
import janken.step4.logic.HandNumber;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class HandNumberTest {

    @Test
    public void _12は数値表現として無効() throws Exception {
        assertThat(HandNumber.isValid("12")).isFalse();
    }

    @Test
    public void _1は数値表現として有効() throws Exception {
        assertThat(HandNumber.isValid("1")).isTrue();
    }

    @Test
    public void _2は数値表現として有効() throws Exception {
        assertThat(HandNumber.isValid("2")).isTrue();
    }

    @Test
    public void _3は数値表現として有効() throws Exception {
        assertThat(HandNumber.isValid("3")).isTrue();
    }

    @Test
    public void _4は数値表現として無効() throws Exception {
        assertThat(HandNumber.isValid("4")).isFalse();
    }

    @Test
    public void aは数値表現として無効() throws Exception {
        assertThat(HandNumber.isValid("a")).isFalse();
    }

    @Test
    public void _1を指定すると出し手のグーが取得できる() throws Exception {
        assertThat(HandNumber.toHand(1)).isEqualTo(Hand.ROCK);
    }

    @Test
    public void _2を指定すると出し手のチョキが取得できる() throws Exception {
        assertThat(HandNumber.toHand(2)).isEqualTo(Hand.SCISSORS);
    }

    @Test
    public void _3を指定すると出し手のパーが取得できる() throws Exception {
        assertThat(HandNumber.toHand(3)).isEqualTo(Hand.PAPER);
    }
}