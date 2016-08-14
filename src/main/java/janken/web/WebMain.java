package janken.web;

import janken.JankenGame;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan
public class WebMain implements JankenGame {
    @Override
    public void execute() {
        SpringApplication.run(WebMain.class);
    }
}
