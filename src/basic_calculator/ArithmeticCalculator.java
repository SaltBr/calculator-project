package basic_calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class ArithmeticCalculator <T extends Number> {
    private String [] currentResult= {"0", "false", ""};
    private final static List<String> resultList = new ArrayList<>();

    //result getter
    public String[] getResult(T calcNum1, T calcNum2, OperatorType calcSymbol) {
        calculate(calcNum1, calcNum2, calcSymbol);
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

    //입력받은 값보다 큰 결과값 출력
    public void getLargeResults(String initNum){
        double baseNum = Double.parseDouble(initNum);
        List<Double> returnList = resultList.stream().map(num -> Double.parseDouble(num)).filter(num -> num > baseNum).collect(Collectors.toList());
        System.out.println(returnList);
    }

    //계산 메서드
    public void calculate(T calcNum1, T calcNum2, OperatorType calcSymbol) {
        double num1 = calcNum1.doubleValue();
        double num2 = calcNum2.doubleValue();
        switch (calcSymbol) {
            case ADD:
                currentResult[0] = String.format("%.2f", num1 + num2);
                resultList.add(currentResult[0]);
                break;
            case SUBTRACT:
                currentResult[0] = String.format("%.2f", num1 - num2);
                resultList.add(currentResult[0]);
                break;
            case MULTIPLY:
                currentResult[0] = String.format("%.2f", num1 * num2);
                resultList.add(currentResult[0]);
                break;
            case DIVIDE:
                if (num2 != 0) {
                    currentResult[0] = String.format("%.2f", num1 / num2);
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
