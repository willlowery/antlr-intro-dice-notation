package dice;

import java.util.Random;

public class DieRoller {

    private final RandomInteger randomInteger;

    public DieRoller() {
        randomInteger = new RandomInteger() {
            final Random random = new Random();

            public Integer next(Integer upperBound) {
                return random.nextInt(upperBound) + 1;
            }
        };
    }

    public DieRoller(RandomInteger randomInteger) {
        this.randomInteger = randomInteger;
    }

    public Integer roll(DieRollRequest request) {
        if (request == null) {
            return 0;
        }

        Integer result = 0;
        for (int i = 0; i < request.getNumberOfRolls(); i++) {
            result += randomInteger.next(request.getNumberOfFaces());
        }
        return result;
    }


    interface RandomInteger {
        Integer next(Integer upperBound);
    }
}
