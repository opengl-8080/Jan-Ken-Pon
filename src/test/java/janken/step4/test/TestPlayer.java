package janken.step4.test;

import janken.step4.logic.Hand;
import janken.step4.logic.Player;

public class TestPlayer extends Player {

    public TestPlayer(Hand hand) {
        super(() -> hand);
    }

    @Override
    public String getSubject() {
        return "test";
    }
}
