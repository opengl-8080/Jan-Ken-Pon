package janken.step4.logic;

public abstract class Player {
    private final HandSupplier handSupplier;
    private Hand currentHand;

    public Player(HandSupplier handSupplier) {
        this.handSupplier = handSupplier;
    }

    public boolean is(Hand hand) {
        return this.currentHand == hand;
    }

    public Hand pon() {
        Hand next = this.handSupplier.get();
        this.currentHand = next;
        return next;
    }

    public Hand getHand() {
        return this.currentHand;
    }

    abstract public String getSubject();
}
