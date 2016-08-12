package janken.step4.logic;

public class Janken {

    private final Player player1;
    private final Player player2;
    private Player winner;

    public Janken(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void pon() {
        Hand handOfPlayer1 = this.player1.pon();
        Hand handOfPlayer2 = this.player2.pon();

        if (handOfPlayer1 == handOfPlayer2) {
            this.winner = null;
            return;
        }

        this.winner = handOfPlayer1.winTo(handOfPlayer2) ? this.player1 : this.player2;
    }

    public Player getWinner() {
        return this.winner;
    }

    public boolean isDraw() {
        return this.winner == null;
    }
}
