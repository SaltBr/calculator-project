package basic_calculator;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator {
    private final int calcNum1;
    private final int calcNum2;
    private final char calcSymbol;
    private String [] currentResult= {"0", "false", ""};
    private static List<String> resultList = new ArrayList<>();

    ArithmeticCalculator(int num1, int num2, char symbol) {
        this.calcNum1 = num1;
        this.calcNum2 = num2;
        this.calcSymbol = symbol;
    }

    //result getter
    public String[] getResult() {
        calculate();
        return currentResult;
    }

    //result setter
    public void setResult(String[] result) {
        this.currentResult = result;
    }

    //연산 기록 getter
    public int getRemainingResult() {
        return resultList.size();
    }

    //첫 번째 기록 삭제
    public void deleteResult() {
        resultList.remove(0);
        System.out.println(resultList + "\n");
    }

    //계산 메서드
    public void calculate() {
        switch (calcSymbol) {
            case '+':
                currentResult[0] = Integer.toString(calcNum1 + calcNum2);
                resultList.add(currentResult[0]);
                break;
            case '-':
                currentResult[0] = Integer.toString(calcNum1 - calcNum2);
                resultList.add(currentResult[0]);
                break;
            case '*':
            case 'x':
            case 'X':
                currentResult[0] = Integer.toString(calcNum1 * calcNum2);
                resultList.add(currentResult[0]);
                break;
            case '/':
                if (calcNum2 != 0) {
                    currentResult[0] = String.format("%.2f", (1.0 * calcNum1) / calcNum2);
                    resultList.add(currentResult[0]);
                    break;
                } else {
                    currentResult[1] = "true";
                    currentResult[2] = "\n나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.";
                    break;
                }
            default:
                //로직이 없는 기호가 들어올 경우
                System.out.println("지원하지 않는 기호입니다!");
                currentResult[1] = "true";
        }
    }
}
