package janken.web.controller;

import janken.step6.logic.ComputerName;
import janken.step6.logic.Hand;
import janken.step6.logic.HandName;
import janken.step6.logic.HandNumber;
import janken.step6.logic.UserName;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/janken")
public class JankenController {

    private final UserName user = new UserName();
    private final ComputerName computer = new ComputerName();

    @RequestMapping(method = RequestMethod.GET)
    public JankenResponse index(@RequestParam int handNumber) {
        Hand usersHand = HandNumber.toHand(handNumber);
        Hand computersHand = Hand.random();

        JankenResponse response = new JankenResponse();
        response.userMessage = this.user + "が出したのは「" + HandName.of(usersHand) + "」です";
        response.computerMessage = this.computer + "が出したのは「" + HandName.of(computersHand) + "」です";

        if (usersHand == computersHand) {
            response.resultMessage = "あいこです";
            return response;
        }

        response.resultMessage = (usersHand.winTo(computersHand) ? user : computer) + "の勝ちです";
        return response;
    }
}
