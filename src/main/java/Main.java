public class Main {

    public static void main(String[] args) {
        if (java.util.stream.Stream.generate(() -> 999)
            // 先頭メッセージ
            .peek(i -> System.out.println("[1]グー、[2]チョキ、[3]パーを入力してください⇒"))

            // ユーザーの出し手を読み取り
            .map(i -> new UsersHandReader().get(i))

            // 入力値の検証
            .filter(usersInput -> usersInput.matches("^[123]$"))
            .map(Integer::parseInt)

            // ユーザーの出し手の説明を出力
            .peek(usersHand -> new HandDescriptionPrinter("あなた", usersHand))

            // コンピュータの出し手を決定
            .map(usersHand -> new int[]{usersHand, new java.util.Random(System.currentTimeMillis()).nextInt(3) + 1})

            // コンピュータの出し手の説明を出力
            .peek(hands -> new HandDescriptionPrinter("わたし", hands[1]))

            // 結果の判定＋出力
            .peek(hands -> System.out.println(
                            hands[0] == hands[1] ? "あいこです"
                  : hands[0] % 3 + 1 == hands[1] ? "あなたの勝ちです"
                                                 : "わたしの勝ちです")
            ).count() == 0) {}
    }

    static class UsersHandReader extends java.util.HashMap<Integer, String> {
        UsersHandReader() {
            try {
                if (this.put(999, new java.io.BufferedReader(new java.io.InputStreamReader(System.in)).readLine()) == null) {}
            } catch (java.io.IOException e) {}
        }
    }

    static class HandDescriptionPrinter extends java.util.HashMap<Integer, String> {

        HandDescriptionPrinter(String name, int handNumber) {
            if (this.put(1, "グー") == null && this.put(2, "チョキ") == null && this.put(3, "パー") == null
                && this.keySet().stream()
                        .filter(keyHandNumber -> keyHandNumber == handNumber)
                        .map(this::get)
                        .peek(handName -> System.out.println(name + "が出したのは「" + handName + "」です")).count() == 0) {}
        }
    }
}
