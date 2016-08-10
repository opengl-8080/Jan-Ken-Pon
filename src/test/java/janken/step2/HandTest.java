package janken.step2;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class HandTest {

    @Test
    public void _1は数値表現として有効() throws Exception {
        assertThat(Hand.isValid("1")).isTrue();
    }

    @Test
    public void _2は数値表現として有効() throws Exception {
        assertThat(Hand.isValid("2")).isTrue();
    }

    @Test
    public void _3は数値表現として有効() throws Exception {
        assertThat(Hand.isValid("3")).isTrue();
    }

    @Test
    public void _4は数値表現として無効() throws Exception {
        assertThat(Hand.isValid("4")).isFalse();
    }

    @Test
    public void aは数値表現として無効() throws Exception {
        assertThat(Hand.isValid("a")).isFalse();
    }

    @Test
    public void ROCKの表示名はグー() throws Exception {
        assertThat(Hand.ROCK.toString()).isEqualTo("グー");
    }

    @Test
    public void SCISSORSの表示名はチョキ() throws Exception {
        assertThat(Hand.SCISSORS.toString()).isEqualTo("チョキ");
    }

    @Test
    public void PAPERの表示名はパー() throws Exception {
        assertThat(Hand.PAPER.toString()).isEqualTo("パー");
    }

    @Test
    public void _1を指定するとグーが取得できる() throws Exception {
        assertThat(Hand.of(1)).isEqualTo(Hand.ROCK);
    }

    @Test
    public void _2を指定するとチョキが取得できる() throws Exception {
        assertThat(Hand.of(2)).isEqualTo(Hand.SCISSORS);
    }

    @Test
    public void _3を指定するとパーが取得できる() throws Exception {
        assertThat(Hand.of(3)).isEqualTo(Hand.PAPER);
    }

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