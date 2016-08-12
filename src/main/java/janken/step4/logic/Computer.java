package janken.step4.logic;

/**
 * コンピュータ.
 */
public class Computer extends Player {

    public Computer(HandSupplier handSupplier) {
        super(handSupplier);
    }

    @Override
    public String getSubject() {
        return "わたし";
    }
}
