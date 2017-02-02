package dice;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String roll = "6d6";
        System.out.printf("Roll [%s] %d%n", roll, eval(roll));
    }

    private static Integer eval(String toParse) throws IOException {
        return new DiceNotationEval(new DieRoller()).evalList(new Reader_Final().run(toParse));
    }

}
