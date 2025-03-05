package basic_calculator;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            String[] result;
            double[] calcNum = new double[2];
            OperatorType operator = OperatorType.NONE;

            //Input Manager
            InputManager inputManager = new InputManager();

            //숫자 받기
            calcNum = inputManager.NumberInput();

            //계산 기호 받기
            operator = inputManager.OperatorInput();

            //Calculator
            ArithmeticCalculator<Double> calculator = new ArithmeticCalculator<>();
            result = calculator.getResult(calcNum[0], calcNum[1], operator);

            //결과 및 에러 출력
            if (!result[1].equals("true")) {
                System.out.println("\n결과: " + result[0]);
            } else {
                System.out.println(result[2]);
            }

            //종료 및 기타 명령어
            inputManager.CommandInput();
        }
    }
}