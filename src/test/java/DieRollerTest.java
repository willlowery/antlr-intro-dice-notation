import org.junit.Test;

import java.util.LinkedList;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

public class DieRollerTest {

    @Test
    public void roll()  {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(3);
        list.add(4);
        list.add(2);
        list.add(2);

        DieRoller dieRoller = new DieRoller((upperBound) -> list.pop());

        assertThat(dieRoller.roll(null), is(0));
        assertThat(dieRoller.roll(new DieRollRequest(1,6)), is(3));
        assertThat(dieRoller.roll(new DieRollRequest(1,6)), is(4));
        assertThat(dieRoller.roll(new DieRollRequest(2,6)), is(4));
    }

    public void testRandomRoll(){
        int[] results = new int[7];
        DieRoller roller = new DieRoller();

        for (int i = 0; i < 6000; i++) {
            Integer roll = roller.roll(new DieRollRequest(1, 6));
            results[roll] += 1;
        }

        assertThat(results[0], is(0));
        assertThat(results[1], not(is(0)));
        assertThat(results[2], not(is(0)));
        assertThat(results[3], not(is(0)));
        assertThat(results[4], not(is(0)));
        assertThat(results[5], not(is(0)));
        assertThat(results[6], not(is(0)));
    }
}