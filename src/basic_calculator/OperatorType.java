package basic_calculator;

public enum OperatorType {
    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/'),
    NONE(' ');

    final char operator;

    OperatorType (char operator) {
        this.operator = operator;
    }
}