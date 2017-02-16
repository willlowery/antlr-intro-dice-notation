package dice.sm;

public class Subtract implements DieExpression {
    private final DieExpression left;
    private final DieExpression right;

    Subtract(DieExpression left, DieExpression right) {
        this.left = left;
        this.right = right;
    }

    public Integer eval() {
        return left.eval() - right.eval();
    }
}
