package dice;

import org.junit.Test;

import static dice.BiFunctions.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DiceNotationEvalTest {

    @Test
    public void test(){
        DiceNotationEval e = new DiceNotationEval(new DieRoller(upperBound -> 3));

        assertThat(e.eval(), is(0));
        assertThat(e.eval(2), is(2));
        assertThat(e.eval(d(1, 6), PLUS, 2), is(5));
        assertThat(e.eval(d(1, 6), PLUS, 2, PLUS, d(3,20)), is(14));
        assertThat(e.eval(d(4, 6), MINUS, 2), is(10));
    }

    private DieRollRequest d(int numberOfRolls, int numberOfFaces) {
        return new DieRollRequest(numberOfRolls, numberOfFaces);
    }

}