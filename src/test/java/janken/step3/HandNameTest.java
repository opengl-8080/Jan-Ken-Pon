package janken.step3;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class HandNameTest {

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