package basic_calculator;
import java.util.Scanner;

public class BasicCalculator {

    public static void main(String[] args) {
        //Main
        Scanner scanner = new Scanner(System.in);
        String result = "";

        while(true) {
            boolean calcError = false;
            System.out.print("숫자1 입력: ");
            int calcNum1 = scanner.nextInt();
            System.out.print("숫자2 입력: ");
            int calcNum2 = scanner.nextInt();
            //scanner 버퍼 지우기
            scanner.nextLine();

            System.out.print("계산 기호를 입력하세요: ");
            char calcSymbol = scanner.nextLine().charAt(0);

            if (calcSymbol == '+') {
                result = Integer.toString(calcNum1 + calcNum2);
            } else if (calcSymbol == '-'){
                result = Integer.toString(calcNum1 - calcNum2);
            } else if (calcSymbol == '*' || calcSymbol == 'x' || calcSymbol =='X') {
                result =  Integer.toString(calcNum1 * calcNum2);
            } else if (calcSymbol =='/'){
                if (calcNum2 != 0) {
                    result =  String.format("%.2f",(1.0 * calcNum1) / calcNum2);
                } else {
                    calcError = true;
                    System.out.println("\n나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                }
            }
            if (!calcError) {
                System.out.println("\n결과: " + result);
            }
            System.out.println("종료하시겠습니까? (exit) ");
            String userInput = scanner.nextLine();
            if (userInput.equals("exit")) {
                break;
            }
        }
    }
}