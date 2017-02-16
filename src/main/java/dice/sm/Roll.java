package dice.sm;

import dice.DieRollRequest;
import dice.DieRoller;

public class Roll implements DieExpression {

    private final Integer sides;
    private final Integer rolls;
    private final DieRoller roller;

    Roll(Integer rolls, Integer sides, DieRoller roller) {
        this.sides = sides;
        this.rolls = rolls;
        this.roller = roller;
    }

    public Integer getSides() {
        return sides;
    }

    public Integer getRolls() {
        return rolls;
    }


    public Integer eval() {
        return roller.roll(new DieRollRequest(rolls,sides));
    }
}
