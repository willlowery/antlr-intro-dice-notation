package dice.sm;

public class TakeHighest implements DieExpression {


    private final Roll roll;

    TakeHighest(Roll roll) {
        this.roll = roll;
    }

    public Integer eval() {
        Integer first = roll.eval();
        Integer second = roll.eval();
        return first <= second ? second : first;
    }
}
