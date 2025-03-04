package basic_calculator;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            String[] result;
            double[] calcNum = new double[2];
            boolean correctOp = false;
            OperatorType operator = OperatorType.NONE;

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
            while(!correctOp) {
                System.out.print("계산 기호를 입력하세요: ");
                char calcSymbol = scanner.nextLine().charAt(0);
                switch (calcSymbol) {
                    case '+':
                        operator = OperatorType.ADD;
                        correctOp = true;
                        break;
                    case '-':
                        operator = OperatorType.SUBTRACT;
                        correctOp = true;
                        break;
                    case '*':
                    case 'x':
                    case 'X':
                        operator =  OperatorType.MULTIPLY;
                        correctOp = true;
                        break;
                    case '/':
                        operator =  OperatorType.DIVIDE;
                        correctOp = true;
                        break;
                    default:
                        System.out.println("지원하지 않는 기호입니다.");
                }
            }

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
            }
        }
    }
}