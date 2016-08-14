package janken.web.controller;

import janken.step6.logic.HandName;
import janken.step6.logic.HandNumber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {

    @GetMapping
    public String index(Model model) {
        IndexModel indexModel = new IndexModel();
        indexModel.rockName = HandName.ROCK.toString();
        indexModel.scissorsName = HandName.SCISSORS.toString();
        indexModel.paperName = HandName.PAPER.toString();
        indexModel.rockNumber = HandNumber.ROCK.toString();
        indexModel.scissorsNumber = HandNumber.SCISSORS.toString();
        indexModel.paperNumber = HandNumber.PAPER.toString();

        model.addAttribute("model", indexModel);

        return "index";
    }
}
