package janken.step4.logic;

import java.util.Random;

public class RandomHandSupplier implements HandSupplier {

    private final Random random;

    public RandomHandSupplier(Random random) {
        this.random = random;
    }

    @Override
    public Hand get() {
        int number = this.random.nextInt(HandNumber.values().length) + 1;
        return HandNumber.toHand(number);
    }
}
