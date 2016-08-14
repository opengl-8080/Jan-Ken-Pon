package janken.step6.logic;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class HandNameTest {

    @Test
    public void 出し手のグーをもとにグーの名称を取得できる() throws Exception {
        assertThat(HandName.of(Hand.ROCK)).isEqualTo(HandName.ROCK);
    }

    @Test
    public void 出し手のチョキをもとにチョキの名称を取得できる() throws Exception {
        assertThat(HandName.of(Hand.SCISSORS)).isEqualTo(HandName.SCISSORS);
    }

    @Test
    public void 出し手のパーをもとにパーの名称を取得できる() throws Exception {
        assertThat(HandName.of(Hand.PAPER)).isEqualTo(HandName.PAPER);
    }

    @Test
    public void ROCKの表示名はグー() throws Exception {
        assertThat(HandName.ROCK.toString()).isEqualTo("グー");
    }

    @Test
    public void SCISSORSの表示名はチョキ() throws Exception {
        assertThat(HandName.SCISSORS.toString()).isEqualTo("チョキ");
    }

    @Test
    public void PAPERの表示名はパー() throws Exception {
        assertThat(HandName.PAPER.toString()).isEqualTo("パー");
    }
}