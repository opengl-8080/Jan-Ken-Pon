package janken.step4.logic;

/**
 * ユーザー.
 */
public class User extends Player {

    public User(HandSupplier handSupplier) {
        super(handSupplier);
    }

    @Override
    public String getSubject() {
        return "あなた";
    }
}
