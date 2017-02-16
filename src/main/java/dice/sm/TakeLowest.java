package dice.sm;

public class TakeLowest implements DieExpression {

    private final Roll roll;

    TakeLowest(Roll roll) {
        this.roll = roll;
    }

    public Integer eval() {
        Integer first = roll.eval();
        Integer second = roll.eval();
        return first >= second ? second : first;
    }
}
