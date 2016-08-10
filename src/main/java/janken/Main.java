package janken;

import janken.step0.Step0;
import janken.step1.Step1;
import janken.step2.Step2;

public class Main {

    public static void main(String[] args) {
        JankenGame janken;

//        janken = new Step0();
//        janken = new Step1();
        janken = new Step2();

        System.out.println(janken.getClass().getSimpleName());
        janken.execute();
    }
}
