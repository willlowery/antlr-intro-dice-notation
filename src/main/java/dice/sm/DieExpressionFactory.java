package dice.sm;

import dice.DieRoller;

public class DieExpressionFactory {

    private final DieRoller roller;

    public DieExpressionFactory(DieRoller roller) {
        this.roller = roller;
    }

    public Add add(DieExpression left, DieExpression right){
        return new Add(left, right);
    }

    public Constant constant(Integer value){
        return new Constant(value);
    }

    public Roll roll(Integer rolls, Integer sides){
        return new Roll(rolls, sides, roller);
    }

    public TakeHighest highest(Roll roll){
        return new TakeHighest(roll);
    }

    public TakeLowest lowest(Roll roll){
        return new TakeLowest(roll);
    }

    public Subtract subtract(DieExpression left, DieExpression right) {
        return new Subtract(left, right);
    }
}
