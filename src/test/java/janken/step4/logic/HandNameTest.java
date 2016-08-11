package janken.step4.logic;

import janken.step4.logic.Hand;
import janken.step4.logic.HandName;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class HandNameTest {

    @Test
    public void 出し手グーを指定したら_名称グーが取得できる() throws Exception {
        assertThat(HandName.toHandName(Hand.ROCK)).isEqualTo(HandName.ROCK);
    }

    @Test
    public void 出し手チョキを指定したら_名称チョキが取得できる() throws Exception {
        assertThat(HandName.toHandName(Hand.SCISSORS)).isEqualTo(HandName.SCISSORS);
    }

    @Test
    public void 出し手パーを指定したら_名称パーが取得できる() throws Exception {
        assertThat(HandName.toHandName(Hand.PAPER)).isEqualTo(HandName.PAPER);
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