package dice;

import dice.sm.DieExpressionFactory;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String roll = "6d6";
        System.out.printf("Roll [%s] %d%n", roll, eval(roll));
    }

    private static Integer eval(String toParse) throws IOException {
        return new Reader_Final(new DieExpressionFactory(new DieRoller())).run(toParse).eval();
    }

}
