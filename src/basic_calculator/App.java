package basic_calculator;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            String[] result;
            double[] calcNum = new double[2];
            char calcSymbol = ' ';
            boolean isError = false;

            //숫자 받기
            for (int i = 0; i < 2; i++) {
                while (true) {
                    try {
                        System.out.print("숫자" + (i + 1) + " 입력: ");
                        calcNum[i] = Integer.parseInt(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("잘못된 숫자입니다.");
                    }
                }
            }

            //계산 기호 받기
            System.out.print("계산 기호를 입력하세요: ");
            calcSymbol = scanner.nextLine().charAt(0);

            //Calculator
            ArithmeticCalculator<Double, Character> calculator = new ArithmeticCalculator<>(calcNum[0], calcNum[1], calcSymbol);
            result = calculator.getResult();

            //결과 및 에러 출력
            if (!result[1].equals("true")) {
                System.out.println("\n결과: " + result[0]);
            } else {
                System.out.println(result[2]);
            }

            //종료 및 기타 명령어
            System.out.println("계속하시겠습니까? (exit, delete, lr) ");
            String userInput = scanner.nextLine();
            if (userInput.equals("exit")) {
                break;
            } else if (userInput.equals("lr")){
                //입력받은 값보다 큰 결과값 출력
                System.out.print("기준 숫자 입력:  ");
                String inputNum = scanner.nextLine();
                calculator.getLargeResults(inputNum);
            } else if (userInput.equals("delete")) {
                calculator.deleteResult();
                //삭제 가능한 기록이 있을 경우 반복
                while(true){
                    System.out.println("계속하시겠습니까? (exit, delete) ");
                    String nextInput = scanner.nextLine();
                    if (nextInput.equals("delete")) {
                        calculator.deleteResult();
                        if(calculator.getRemainingResult() == 0){
                            break;
                        }
                    } else if (nextInput.equals("exit")) {
                        return;
                    } else {
                        break;
                    }
                }
            }
        }
    }
}