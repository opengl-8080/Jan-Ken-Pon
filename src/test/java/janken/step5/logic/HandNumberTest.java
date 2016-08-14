package janken.step5.logic;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class HandNumberTest {

    @Test
    public void 対応する出し手に変換できる_グー() throws Exception {
        assertThat(HandNumber.ROCK.toHand()).isEqualTo(Hand.ROCK);
    }

    @Test
    public void 対応する出し手に変換できる_チョキ() throws Exception {
        assertThat(HandNumber.SCISSORS.toHand()).isEqualTo(Hand.SCISSORS);
    }

    @Test
    public void 対応する出し手に変換できる_パー() throws Exception {
        assertThat(HandNumber.PAPER.toHand()).isEqualTo(Hand.PAPER);
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