package janken;

import janken.javafx.JavaFxMain;
import janken.step0.Step0;
import janken.step1.Step1;
import janken.step2.Step2;
import janken.step3.Step3;
import janken.step4.Step4;
import janken.step5.Step5;
import janken.step6.Step6;

public class Main {

    public static void main(String[] args) {
        JankenGame janken;

//        janken = new Step0();
//        janken = new Step1();
//        janken = new Step2();
//        janken = new Step3();
//        janken = new Step4();
//        janken = new Step5();
//        janken = new Step6();
        janken = new JavaFxMain();

        System.out.println(janken.getClass().getSimpleName());
        janken.execute();
    }
}
