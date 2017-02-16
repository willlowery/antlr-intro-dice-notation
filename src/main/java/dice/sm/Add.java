package dice.sm;

public class Add implements DieExpression {

    private final DieExpression left;
    private final DieExpression right;

    Add(DieExpression left, DieExpression right) {
        this.left = left;
        this.right = right;
    }

    public Integer eval() {
        return left.eval() + right.eval();
    }
}
