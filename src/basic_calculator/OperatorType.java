package basic_calculator;

public enum OperatorType {
    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    final char operator;

    OperatorType (char operator) {
        this.operator = operator;
    }
}