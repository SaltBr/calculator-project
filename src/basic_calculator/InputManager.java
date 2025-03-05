package basic_calculator;

import java.util.Scanner;

public class InputManager {
    Scanner scanner = new Scanner(System.in);

    public double[] NumberInput() {
        double[] calcNum = new double[2];
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
        return calcNum;
    }

    public OperatorType OperatorInput() {
        boolean correctOp = false;
        OperatorType operator = OperatorType.NONE;

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
        return operator;
    }
}
