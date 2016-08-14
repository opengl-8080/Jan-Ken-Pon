package janken.step5;

import janken.JankenGame;
import janken.step5.controller.JankenController;
import janken.step5.logic.ComputerName;
import janken.step5.logic.UserName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;

/**
 * 第５ステップ、「１行につきドットは１つまでにすること」を適用.
 * <p>
 * 修正するかどうかの判定基準は「１行にドットが複数存在する」かつ「デルメルの法則に反している」にしたので、
 * ドットが２つ以上あってもデルメルの法則に反していないのであれば、そのままにしています.
 * <p>
 * なぜかというと、「１行１ドット」というルールはデルメルの法則に反している箇所を特定する目安のためのルールなので、
 * そもそもデルメルの法則に反していないのであれば修正の必要はないからです.
 *
 * <h3>デルメルの法則</h3>
 * オブジェクトO上のメソッドMが呼び出してもよいメソッドは以下のオブジェクトに属するメソッドのみに限定される。
 * <ol>
 *   <li>Oそれ自身
 *   <li>Mの引数に渡されたオブジェクト
 *   <li>Mの内部でインスタンス化されたオブジェクト
 *   <li>Oを直接的に構成するオブジェクト（Oのインスタンス変数）
 * </ol>
 *
 * 参考：<a href="https://ja.wikipedia.org/wiki/%E3%83%87%E3%83%A1%E3%83%86%E3%83%AB%E3%81%AE%E6%B3%95%E5%89%87">デルメルの法則 | Wikipedia</a>
 *
 * <h3>例1 : {@link JankenController}</h3>
 * <code><pre>
 * HandNumber.of(userInput.toInt()).toHand()
 * </pre></code>
 * <p>
 * {@link janken.step5.logic.HandNumber HandNumber} が返した {@link janken.step5.logic.Hand Hand} は {@link JankenController} が
 * 直接生成したインスタンスではないので、デルメルの法則に反している.
 *
 * <h3>例2 : {@link janken.step5.logic.HandNumber HandNumber}</h3>
 * <code><pre>
 * HandNumber.values()[RANDOM.nextInt(Hand.values().length)]
 * </pre></code>
 * <p>
 * 複数のドットが存在するが、いずれも自分（{@link janken.step5.logic.HandNumber HandNumber}）が直接参照している
 * クラスのメソッド参照に限られている.<br>
 * {@code Hand.values().length} はメソッドではなくフィールドの参照なので、デルメルの法則には反していない.
 */
public class Step5 implements JankenGame {

    @Override
    public void execute() {
        try {
            UserName user = new UserName();
            ComputerName computer = new ComputerName();
            BufferedReader standardInput = new BufferedReader(new InputStreamReader(System.in));

            JankenController controller = new JankenController();
            controller.execute(user, computer, standardInput);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
