package basic_calculator;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        //Main
        Scanner scanner = new Scanner(System.in);
        String [] result = {"resultNum", "errorBoolean", "errorMessage"};

        while(true) {
            boolean calcError = false;

            //숫자 받기
            System.out.print("숫자1 입력: ");
            int calcNum1 = scanner.nextInt();
            System.out.print("숫자2 입력: ");
            int calcNum2 = scanner.nextInt();
            //scanner 버퍼 지우기
            scanner.nextLine();

            //계산 기호 받기
            System.out.print("계산 기호를 입력하세요: ");
            char calcSymbol = scanner.nextLine().charAt(0);

            Calculator calculator = new Calculator(calcNum1, calcNum2, calcSymbol, result);
            result = calculator.calculate();

            if (!calculator.result[1].equals("true")) {
                System.out.println("\n결과: " + calculator.result[0]);
            } else {
                System.out.println("에러! " + calculator.result[2]);
            }

            System.out.println("종료하시겠습니까? (exit) ");
            String userInput = scanner.nextLine();
            if (userInput.equals("exit")) {
                break;
            }
        }
    }
}
