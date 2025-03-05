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
            ArithmeticCalculator<Double> calculator = new ArithmeticCalculator<>(calcNum[0], calcNum[1], operator);
            result = calculator.getResult();

            //결과 및 에러 출력
            if (!result[1].equals("true")) {
                System.out.println("\n결과: " + result[0]);
            } else {
                System.out.println(result[2]);
            }

            //종료 및 기타 명령어
            //exit: 종료
            //delete: 첫 연산 기록 삭제
            //lr: 더 큰 결과값 출력
            System.out.println("계속하시겠습니까? (exit, delete, lr) ");
            String userInput = scanner.nextLine();
            boolean repeat = true;
            switch(userInput){
                case "exit":
                    System.exit(0);
                case "lr":
                    System.out.print("기준 숫자 입력:  ");
                    String inputNum = scanner.nextLine();
                    calculator.getLargeResults(inputNum);
                    break;
                case "delete":
                    calculator.deleteResult();
                    //삭제 가능한 기록이 있을 경우 반복
                    while(repeat){
                        System.out.println("계속하시겠습니까? (exit, delete) ");
                        String nextInput = scanner.nextLine();
                        if (nextInput.equals("delete")) {
                            calculator.deleteResult();
                            if(calculator.getRemainingResult() == 0){
                                System.out.println("더 이상 지울 수 있는 결과가 없습니다.");
                                repeat = false;
                            }
                        } else if (nextInput.equals("exit")) {
                            System.exit(0);
                        } else {
                            return;
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }
}