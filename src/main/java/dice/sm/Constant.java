package dice.sm;

public class Constant implements DieExpression {

    private final Integer value;

    Constant(Integer value) {
        this.value = value;
    }

    public Integer eval() {
        return value;
    }
}
