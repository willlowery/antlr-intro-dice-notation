package dice;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static dice.BiFunctions.MINUS;
import static dice.BiFunctions.PLUS;
import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Reader_FinalTest {

    @Test
    public void test() throws IOException {
        assertThat(read("1d6"), is(asList(D(1, 6))));
        assertThat(read("1d6+1"), is(asList(D(1, 6), PLUS, 1)));
        assertThat(read("1d6-1"), is(asList(D(1, 6), MINUS, 1)));
        assertThat(
                read("1d4+1d6-1d8+1d10-1d12+1d20-120"),
                is(asList(D(1, 4), PLUS, D(1, 6), MINUS, D(1, 8), PLUS, D(1, 10), MINUS, D(1, 12), PLUS, D(1, 20), MINUS, 120))
        );

    }

    private List<Object> read(String toParse) throws IOException {
        return new Reader_Final().run(toParse);
    }

    private DieRollRequest D(int numberOfRolls, int numberOfFaces) {
        return new DieRollRequest(numberOfRolls, numberOfFaces);
    }

}