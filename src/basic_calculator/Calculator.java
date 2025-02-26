package basic_calculator;

public class Calculator {
    private final int calcNum1;
    private final int calcNum2;
    private final char calcSymbol;
    private String [] result= {"0", "false", ""};

    Calculator(int num1, int num2, char symbol) {
        this.calcNum1 = num1;
        this.calcNum2 = num2;
        this.calcSymbol = symbol;
    }

    public String[] getResult() {
        calculate();
        return result;
    }

    public void setResult(String[] result) {
        this.result = result;
    }

    //계산 메서드
    public void calculate() {
        switch (calcSymbol) {
            case '+':
                result[0] = Integer.toString(calcNum1 + calcNum2);
                break;
            case '-':
                result[0] = Integer.toString(calcNum1 - calcNum2);
                break;
            case '*':
                result[0] = Integer.toString(calcNum1 * calcNum2);
                break;
            case '/':
                if (calcNum2 != 0) {
                    result[0] = Integer.toString(calcNum1 / calcNum2);
                    break;
                } else {
                    result[1] = "true";
                    result[2] = "\n나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.";
                    break;
                }
        }
    }
}
